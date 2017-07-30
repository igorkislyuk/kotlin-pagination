package ru.touchin.pagination.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.touchin.pagination.dao.MessageDao
import ru.touchin.pagination.entity.models.Message
import ru.touchin.pagination.services.MessageService

@Service
@Transactional
open class MessageServiceImpl : MessageService {

    @Autowired
    lateinit var messageDao: MessageDao

    override fun addMessage(message: Message): Message = messageDao.addMessage(message)

    override fun messagesFromTop(limit: Int, offset: Int): List<Message> = messageDao.messagesFromTop(limit, offset)

    override fun messages(sinceId: String, tillId: String): List<Message> = messageDao.messages(sinceId, tillId)

    override fun messagesSince(id: String, limit: Int): List<Message> = messageDao.messagesSince(id, limit)

    override fun messagesTill(id: String, limit: Int): List<Message> = messageDao.messagesTill(id, limit)
}