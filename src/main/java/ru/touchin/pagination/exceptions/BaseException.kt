package ru.touchin.pagination.exceptions

class BaseException(val code: Int = -1, override val message: String): RuntimeException() {

    companion object Factory {
        fun invalidRequestException() = BaseException(1, "Неверные параметры запроса.")
    }

}