package ro.asis.green.account.service.model.filters

data class AccountFilters(
    var username: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    var type: String? = null,
    var role: String? = null
)
