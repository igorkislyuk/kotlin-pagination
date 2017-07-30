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

    override fun messagesFromTop(limit: Int, offset: Int): List<Message> {
        return sessionFactory.currentSession.createCriteria(Message::class.java)
                .addOrder(Order.desc("date"))
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list()
                .filterIsInstance(Message::class.java)
    }

    override fun messages(sinceId: String, tillId: String): List<Message> {
        val sinceDate = getMessage(sinceId)?.date ?: return emptyList()
        val tillDate = getMessage(tillId)?.date ?: return emptyList()

        return sessionFactory.currentSession.createCriteria(Message::class.java)
                .addOrder(Order.desc("date"))
                .add(Restrictions.between("date", sinceDate, tillDate))
                .list()
                .filterIsInstance(Message::class.java)
    }

    override fun messagesSince(id: String, limit: Int): List<Message> {
        val sinceDate = getMessage(id)?.date ?: return emptyList()

        return sessionFactory.currentSession.createCriteria(Message::class.java)
                .addOrder(Order.desc("date"))
                .add(Restrictions.ge("date", sinceDate))
                .list()
                .filterIsInstance(Message::class.java)
    }

    override fun messagesTill(id: String, limit: Int): List<Message> {
        val tillDate = getMessage(id)?.date ?: return emptyList()

        return sessionFactory.currentSession.createCriteria(Message::class.java)
                .addOrder(Order.desc("date"))
                .add(Restrictions.le("date", tillDate))
                .list()
                .filterIsInstance(Message::class.java)
    }

    // Private

    private fun getMessage(identifier: String): Message? {
        return sessionFactory.currentSession.createCriteria(Message::class.java)
                .addOrder(Order.desc("date"))
                .add(Restrictions.eq("id", identifier))
                .uniqueResult() as? Message ?: return null
    }

}