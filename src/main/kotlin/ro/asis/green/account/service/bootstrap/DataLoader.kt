package ro.asis.green.account.service.bootstrap

import org.bson.types.ObjectId
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ro.asis.green.account.service.model.api.dto.AccountDto
import ro.asis.green.account.service.model.enums.AccountRole.ADMIN
import ro.asis.green.account.service.model.enums.AccountRole.USER
import ro.asis.green.account.service.model.enums.AccountType.*
import ro.asis.green.account.service.service.AccountService

@Component
class DataLoader(private val accountService: AccountService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        accountService.addAccount(
//            AccountDto(
//                id = ObjectId.get().toHexString(),
//                username = "markvaradi94",
//                password = "mazare123",
//                email = "mark@geza.hu",
//                phoneNumber = "0744875145",
//                type = PROVIDER,
//                role = USER
//            )
//        )
//        accountService.addAccount(
//            AccountDto(
//                id = ObjectId.get().toHexString(),
//                username = "renitzi14",
//                password = "portocala",
//                email = "ren@olaf.com",
//                phoneNumber = "0744657812",
//                type = CLIENT,
//                role = USER
//            )
//        )
//        accountService.addAccount(
//            AccountDto(
//                id = ObjectId.get().toHexString(),
//                username = "margitka",
//                password = "ilovecats4eva",
//                email = "marge@gigi.com",
//                phoneNumber = "0732623894",
//                type = ADMINISTRATOR,
//                role = ADMIN
//            )
//        )
    }
}
