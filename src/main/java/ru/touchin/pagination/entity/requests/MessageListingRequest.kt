package ru.touchin.pagination.entity.requests

import com.fasterxml.jackson.annotation.JsonProperty
import ru.touchin.pagination.entity.exceptions.InvalidRequestException

class MessageListingRequest : Request {

    @JsonProperty("limit", required = true)
    val limit: Int? = null

    @JsonProperty("offset", required = true)
    val offset: Int? = null

    @JsonProperty("since_id", required = false)
    val sinceID: String? = null

    @JsonProperty("till_id", required = false)
    val tillID: String? = null

    override fun isValid(): Boolean {
        if (limit == null) {
            return false
        }

        if (offset == null) {
            return false
        }

        return true
    }

    val listingType: MessageListingType
        get() {
            if (!isValid()) {
                throw InvalidRequestException("MessageListingRequest is not valid")
            }

            val sinceIdNull = sinceID == null
            val tillIdNull = tillID == null

            if (sinceIdNull && tillIdNull) {
                return MessageListingType.limitOffset
            } else if (sinceIdNull && !tillIdNull) {
                return MessageListingType.limitTill
            } else if (tillIdNull && !sinceIdNull) {
                return MessageListingType.limitSince
            } else {
                return MessageListingType.sinceTillId
            }
        }

    val limitOffset: Pair<Int, Int>
        get() {
            if (listingType != MessageListingType.limitOffset) {
                throw InvalidRequestException("Check first listing type")
            }

            return Pair(limit!!, offset!!)
        }

    val sinceTillIds: Pair<String, String>
        get() {
            if (listingType != MessageListingType.sinceTillId) {
                throw InvalidRequestException("Check first listing type")
            }

            return Pair(sinceID!!, tillID!!)
        }
}