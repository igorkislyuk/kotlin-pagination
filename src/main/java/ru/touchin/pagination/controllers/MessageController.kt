package ru.touchin.pagination.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import ru.touchin.pagination.exceptions.BaseException
import ru.touchin.pagination.entity.responses.BaseResponse
import ru.touchin.pagination.entity.requests.MessageCreateRequest
import ru.touchin.pagination.entity.requests.MessageListingRequest
import ru.touchin.pagination.entity.requests.MessageListingType
import ru.touchin.pagination.services.MessageService
import javax.validation.Valid

@Controller
class MessageController : ExceptionHandlingController() {

    @Autowired
    lateinit var messageService: MessageService

    @PostMapping("/message/create")
    fun messageCreate(@Valid @RequestBody messageCreateRequest: MessageCreateRequest): ResponseEntity<BaseResponse> {
        // validate
        if (!messageCreateRequest.isValid()) {
            return invalidResponse()
        }

        // create message
        val message = messageCreateRequest.message
        if (message != null) messageService.addMessage(message)

        // return as response
        return ResponseEntity.ok(BaseResponse(true))
    }

    @PostMapping("/message/listing")
    fun messageListing(@Valid @RequestBody messageListingRequest: MessageListingRequest): ResponseEntity<BaseResponse> {
        if (!messageListingRequest.isValid()) {
            return invalidResponse()
        }

        if (messageListingRequest.listingType == MessageListingType.limitOffset) {
            val (limit, offset) = messageListingRequest.limitOffset
            val messages = messageService.messagesFromTop(limit = limit, offset = offset)
            return ResponseEntity.ok(BaseResponse(messages))
        } else {
            return invalidResponse()
        }
    }

    private fun invalidResponse() = ResponseEntity.ok(BaseResponse(BaseException.invalidRequestException()))
}