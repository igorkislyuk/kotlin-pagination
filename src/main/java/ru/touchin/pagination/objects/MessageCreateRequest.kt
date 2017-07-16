package ru.touchin.pagination.objects

import com.fasterxml.jackson.annotation.JsonProperty

class MessageCreateRequest: Request {

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
}