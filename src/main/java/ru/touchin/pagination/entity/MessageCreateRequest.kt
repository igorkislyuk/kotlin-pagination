package ru.touchin.pagination.entity

import com.fasterxml.jackson.annotation.JsonProperty
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

            return Message(author!!, text!!, Date(Calendar.getInstance().time.time))
        }
}