package ru.touchin.pagination.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.touchin.pagination.dao.MessageDao
import ru.touchin.pagination.entity.Message
import ru.touchin.pagination.services.MessageService

@Service
@Transactional
open class MessageServiceImpl : MessageService {

    @Autowired
    lateinit var messageDao: MessageDao

    override fun addMessage(message: Message): Message = messageDao.addMessage(message)

}