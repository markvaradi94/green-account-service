package ro.asis.green.account.service.service

import com.mongodb.annotations.ThreadSafe
import mu.KotlinLogging
import org.springframework.stereotype.Service
import ro.asis.green.account.service.exceptions.AccountNotFoundException
import ro.asis.green.account.service.model.api.dto.AccountDto
import ro.asis.green.account.service.model.entity.AccountEntity
import ro.asis.green.account.service.model.filters.AccountFilters
import ro.asis.green.account.service.model.mappers.AccountMapper
import ro.asis.green.account.service.repository.AccountDao
import ro.asis.green.account.service.repository.AccountRepository

@Service
@ThreadSafe
class AccountService(
    private val accountRepository: AccountRepository,
    private val accountDao: AccountDao,
    private val accountMapper: AccountMapper
) {

    companion object {
        private val LOG = KotlinLogging.logger { }
    }

    fun findAll(filters: AccountFilters): List<AccountDto> =
        accountMapper.toApi(accountDao.findAccounts(filters)).toList()

    fun findAccount(accountId: String) = accountMapper.toApi(
        accountRepository.findById(accountId)
            .orElseThrow { AccountNotFoundException("Could not find account") }
    )

    fun addAccount(account: AccountDto): AccountDto = accountMapper.toApi(
        accountRepository.save(
            accountMapper.toEntity(account)
        )
    )

    fun deleteAccount(accountId: String): AccountDto {
        val accountToDelete = getOrThrow(accountId)
        accountRepository.delete(accountToDelete)
        return accountMapper.toApi(accountToDelete)
    }

    fun patchAccount(accountId: String, account: AccountDto): AccountDto {
        val dbAccount = getOrThrow(accountId)
        copyAccount(account, dbAccount)
        return accountMapper.toApi(accountRepository.save(dbAccount))
    }

    private fun copyAccount(newAccount: AccountDto, dbAccount: AccountEntity) {
        dbAccount.email = newAccount.email ?: dbAccount.email
        dbAccount.phoneNumber = newAccount.phoneNumber ?: dbAccount.phoneNumber
        dbAccount.password = newAccount.password ?: dbAccount.password
    }

    private fun getOrThrow(accountId: String) = accountRepository
        .findById(accountId)
        .orElseThrow { AccountNotFoundException("Could not find account with id $accountId") }
}
