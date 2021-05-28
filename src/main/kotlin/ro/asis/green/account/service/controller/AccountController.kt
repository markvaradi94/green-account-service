package ro.asis.green.account.service.controller

import org.springframework.web.bind.annotation.*
import ro.asis.green.account.service.model.api.dto.AccountDto
import ro.asis.green.account.service.model.filters.AccountFilters
import ro.asis.green.account.service.service.AccountService

@RestController
@RequestMapping("accounts")
class AccountController(
    private val accountService: AccountService
) {
    @GetMapping
    fun getAllAccounts(filters: AccountFilters): List<AccountDto> = accountService.findAll(filters)

    @GetMapping("{accountId}")
    fun getAccountById(@PathVariable accountId: String): AccountDto = accountService.findAccount(accountId)

    @PostMapping
    fun addAccount(@RequestBody account: AccountDto): AccountDto = accountService.addAccount(account)

    @PatchMapping("{accountId}")
    fun patchAccount(
        @PathVariable accountId: String,
        @RequestBody account: AccountDto
    ): AccountDto = accountService.patchAccount(accountId, account)

    @DeleteMapping("{accountId}")
    fun deleteAccount(@PathVariable accountId: String) = accountService.deleteAccount(accountId)
}
