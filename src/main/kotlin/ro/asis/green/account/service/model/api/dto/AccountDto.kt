package ro.asis.green.account.service.model.api.dto

import org.bson.types.ObjectId
import ro.asis.green.account.service.model.enums.AccountRole
import ro.asis.green.account.service.model.enums.AccountType

data class AccountDto(
    var id: String = ObjectId.get().toHexString(),
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var type: AccountType? = null,
    var role: AccountRole? = null
)
