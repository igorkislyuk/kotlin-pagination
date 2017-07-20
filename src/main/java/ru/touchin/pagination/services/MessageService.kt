package ru.touchin.pagination.services

import ru.touchin.pagination.entity.Message

interface MessageService {

//    fun messageWith(identifier: String?): Message?
//
//    fun createMessage(message: Message): Boolean
    fun addMessage(message: Message): Message

}