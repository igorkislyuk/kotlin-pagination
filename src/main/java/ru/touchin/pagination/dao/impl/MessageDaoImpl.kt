package ru.touchin.pagination.dao.impl

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.touchin.pagination.dao.MessageDao
import ru.touchin.pagination.entity.Message

@Repository
open class MessageDaoImpl: MessageDao {

    @Autowired
    lateinit var sessionFactory: SessionFactory

    override fun addMessage(message: Message): Message {
        sessionFactory.currentSession.save(message)
        return message
    }
}