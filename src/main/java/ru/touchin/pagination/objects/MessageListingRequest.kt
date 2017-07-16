package ru.touchin.pagination.objects

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class MessageListingRequest: Request {

    @JsonProperty("limit", required = true)
    val limit: Int? = null

    @JsonProperty("offset", required = true)
    val offset: Int? = null

    @JsonProperty("since_id", required = false)
    val sinceID: UUID? = null

    @JsonProperty("till_id", required = false)
    val tillID: UUID? = null

    override fun isValid(): Boolean {
        if (limit == null) {
            return false
        }

        if (offset == null) {
            return false
        }

        return true
    }
}