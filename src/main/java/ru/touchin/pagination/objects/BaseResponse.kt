package ru.touchin.pagination.objects

class BaseResponse(val result: Any?,
                   val errorCode: Int = 0,
                   val message: String? = null)