package ru.touchin.pagination.dao.impl

import org.hibernate.SessionFactory
import org.hibernate.criterion.Order
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.touchin.pagination.dao.MessageDao
import ru.touchin.pagination.entity.models.Message

@Repository
open class MessageDaoImpl : MessageDao {

    @Autowired
    lateinit var sessionFactory: SessionFactory

    override fun addMessage(message: Message): Message {
        sessionFactory.currentSession.save(message)
        return message
    }

    fun getMessage(identifier: String): Message? {
        return sessionFactory.currentSession.createCriteria(Message::class.java)
                .add(Restrictions.eq("id", identifier))
                .uniqueResult() as? Message ?: return null
    }

    override fun messagesFromTop(limit: Int, offset: Int): List<Message> {
        return sessionFactory.currentSession.createCriteria(Message::class.java)
                .addOrder(Order.desc("date"))
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list()
                .filterIsInstance(Message::class.java)
//        return emptyList()
    }

    override fun messages(sinceId: String, tillId: String, ascending: Boolean): Array<Message>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}