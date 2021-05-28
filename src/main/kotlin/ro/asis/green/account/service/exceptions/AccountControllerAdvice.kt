package ro.asis.green.account.service.exceptions

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AccountControllerAdvice {
    @ExceptionHandler(AccountNotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    fun handleAccountNotFoundException(exception: AccountNotFoundException): ApiError =
        ApiError(exception.localizedMessage)
}

data class ApiError(val message: String?)

class AccountNotFoundException(message: String?) : RuntimeException(message)
