package ru.touchin.pagination.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.touchin.pagination.exceptions.BaseException
import ru.touchin.pagination.objects.BaseResponse

@RestController
open class ExceptionHandlingController {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.OK)
    fun handleException(exception: MethodArgumentNotValidException) =
            BaseResponse(null,
                    BaseException.invalidRequestException().code,
                    exception.message)

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.OK)
    fun handleException(exception: Exception): BaseResponse {
        if (exception is BaseException) {
            return BaseResponse(exception)
        }

        return BaseResponse(null, -1, exception.message)
    }
}