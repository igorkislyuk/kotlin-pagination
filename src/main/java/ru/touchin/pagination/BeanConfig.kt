package ru.touchin.pagination

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import ru.touchin.pagination.services.MessageService
import ru.touchin.pagination.services.MessageServiceImpl

@Configuration
@EnableTransactionManagement
open class BeanConfig {

    @Bean
    open fun getMessageService(): MessageService {
        return MessageServiceImpl()
    }
}