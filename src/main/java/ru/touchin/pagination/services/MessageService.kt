package ru.touchin.pagination.services

import ru.touchin.pagination.entity.models.Message

interface MessageService {

    fun addMessage(message: Message): Message

    fun messagesFromTop(limit: Int, offset: Int): List<Message>

    fun messages(sinceId: String, tillId: String, ascending: Boolean = false): List<Message>
}