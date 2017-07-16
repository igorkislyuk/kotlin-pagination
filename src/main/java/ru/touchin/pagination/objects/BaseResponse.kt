package ru.touchin.pagination.objects

import com.fasterxml.jackson.annotation.JsonProperty
import ru.touchin.pagination.exceptions.BaseException

class BaseResponse(val result: Any?,
                   code: Int = 0,
                   message: String? = null) {

    constructor(exception: BaseException): this(null, exception.code, exception.message)

    @JsonProperty("error_code")
    val errorCode = code

    @JsonProperty("error_message")
    val errorMessage = message
}