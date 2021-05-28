package ro.asis.green.account.service.model.mappers

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import ro.asis.green.account.service.model.api.dto.AccountDto
import ro.asis.green.account.service.model.entity.AccountEntity

@Component
@RequiredArgsConstructor
class AccountMapper : Mapper<AccountDto, AccountEntity> {
    override fun toApi(source: AccountEntity): AccountDto {
        return AccountDto(
            id = source.id,
            username = source.username,
            password = source.password,
            email = source.email,
            phoneNumber = source.phoneNumber,
            type = source.type,
            role = source.role
        )
    }

    override fun toEntity(source: AccountDto): AccountEntity {
        return AccountEntity(
            id = source.id,
            username = source.username,
            password = source.password,
            email = source.email,
            phoneNumber = source.phoneNumber,
            type = source.type,
            role = source.role
        )
    }
}
