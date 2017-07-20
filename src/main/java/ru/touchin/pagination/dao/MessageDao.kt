package ru.touchin.pagination.dao

import ru.touchin.pagination.entity.Message

interface MessageDao {

    fun addMessage(message: Message): Message
}