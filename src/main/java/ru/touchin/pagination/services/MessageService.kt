package ru.touchin.pagination.services

import ru.touchin.pagination.objects.Message

interface MessageService {

    fun messageWith(identifier: String?): Message?

    fun createMessage(message: Message): Boolean

}