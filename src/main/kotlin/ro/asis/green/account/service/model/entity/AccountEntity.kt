package ro.asis.green.account.service.model.entity

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ro.asis.green.account.service.model.enums.AccountRole
import ro.asis.green.account.service.model.enums.AccountRole.USER
import ro.asis.green.account.service.model.enums.AccountType
import ro.asis.green.account.service.model.enums.AccountType.CLIENT
import javax.validation.constraints.Email

@Data
@Document(collection = "accounts")
class AccountEntity(
    @Id
    var id: String = ObjectId.get().toHexString(),

    var username: String? = "",

    var password: String? = "",

    @Email
    var email: String? = "example@default.com",

    var phoneNumber: String? = "",

    var type: AccountType? = CLIENT,

    var role: AccountRole? = USER
)
