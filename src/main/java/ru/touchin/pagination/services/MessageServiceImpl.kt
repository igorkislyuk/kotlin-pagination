package ru.touchin.pagination.services

import org.hibernate.SessionFactory
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import ru.touchin.pagination.objects.Message
import javax.persistence.EntityManagerFactory

class MessageServiceImpl : MessageService {

    @Autowired
    lateinit var entityManagerFactory: EntityManagerFactory

    val sessionFactory: SessionFactory
        get() {
            if (entityManagerFactory.unwrap(SessionFactory::class.java) == null) {
                throw NullPointerException("factory is not a hibernate factory")
            }
            return entityManagerFactory.unwrap(SessionFactory::class.java)
        }

    override fun messageWith(identifier: String?): Message? {

        return null
    }

    override fun createMessage(message: Message): Boolean {
        sessionFactory.currentSession.save(message)

        return true
    }
}