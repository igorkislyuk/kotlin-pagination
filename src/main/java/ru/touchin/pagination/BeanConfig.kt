package ru.touchin.pagination

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import ru.touchin.pagination.services.MessageService
import ru.touchin.pagination.services.impl.MessageServiceImpl
import javax.persistence.EntityManagerFactory

@Configuration
@EnableTransactionManagement
open class BeanConfig {

    @Autowired
    lateinit open var entityManagerFactory: EntityManagerFactory

    @Bean
    open fun getSessionFactory(): SessionFactory {
        if (entityManagerFactory.unwrap(SessionFactory::class.java) == null) {
            throw NullPointerException("factory is not a hibernate factory")
        }
        return entityManagerFactory.unwrap(SessionFactory::class.java)
    }
}