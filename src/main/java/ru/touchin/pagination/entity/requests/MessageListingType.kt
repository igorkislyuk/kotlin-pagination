package ru.touchin.pagination.entity.requests

enum class MessageListingType {
    limitOffset,
    limitSince,
    limitTill,
    sinceTillId
}