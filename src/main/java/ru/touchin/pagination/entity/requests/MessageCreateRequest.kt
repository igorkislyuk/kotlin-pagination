package ru.touchin.pagination.entity.requests

import com.fasterxml.jackson.annotation.JsonProperty
import ru.touchin.pagination.entity.models.Message
import java.sql.Date
import java.util.*

class MessageCreateRequest : Request {

    @JsonProperty("author")
    val author: String? = null

    @JsonProperty("text")
    val text: String? = null

    override fun isValid(): Boolean {
        if (author.isNullOrEmpty()) {
            return false
        }

        if (text.isNullOrEmpty()) {
            return false
        }

        return true
    }

    val message: Message?
        get() {
            if (!isValid()) {
                return null
            }

            val message = Message()
            message.authorName = author!!
            message.text = text!!
            message.date = Date(Calendar.getInstance().time.time)
            return message
        }
}