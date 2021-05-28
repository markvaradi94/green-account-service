package ro.asis.green.account.service.model.filters

import ro.asis.green.account.service.model.enums.AccountRole
import ro.asis.green.account.service.model.enums.AccountType

data class AccountFilters(
    var username: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var type: AccountType? = null,
    var role: AccountRole? = null
)
