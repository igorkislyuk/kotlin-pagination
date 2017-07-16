package ru.touchin.pagination.services

import org.hibernate.Session
import org.hibernate.SessionFactory
import ru.touchin.pagination.objects.Message
import javax.persistence.Persistence

class MessageServiceImpl : MessageService {
//
//    val sessionFactory: SessionFactory
//        get() {
//            if (entityManagerFactory.unwrap(SessionFactory::class.java) == null) {
//                throw NullPointerException("factory is not a hibernate factory")
//            }
//
//            return entityManagerFactory.unwrap(SessionFactory::class.java)
//        }

    override fun messageWith(identifier: String?): Message? {

        return null
    }

    override fun createMessage(message: Message): Boolean {
        try {

        val sessionFactory = Persistence.createEntityManagerFactory("ru.touchin.persistence")
        val entityManager = sessionFactory.createEntityManager()

        entityManager.transaction.begin()

        entityManager.persist(message)

        entityManager.transaction.commit()

        entityManager.close()

        }
        catch (exception: Exception) {

            println("O my fucking java")
        }
        return true
    }
}