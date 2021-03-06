package ru.touchin.pagination.dao

import ru.touchin.pagination.entity.models.Message

interface MessageDao {

    fun addMessage(message: Message): Message

    fun messagesFromTop(limit: Int, offset: Int): List<Message>

    fun messages(sinceId: String, tillId: String): List<Message>

    fun messagesSince(id: String, limit: Int): List<Message>

    fun messagesTill(id: String, limit: Int): List<Message>
}