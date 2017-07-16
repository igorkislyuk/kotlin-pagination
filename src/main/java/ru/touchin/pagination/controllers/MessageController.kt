package ru.touchin.pagination.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.touchin.pagination.exceptions.BaseException
import ru.touchin.pagination.objects.BaseResponse
import ru.touchin.pagination.objects.MessageCreateRequest
import ru.touchin.pagination.objects.MessageListingRequest
import ru.touchin.pagination.services.MessageService
import javax.validation.Valid

@RestController
class MessageController : ExceptionHandlingController() {

    @Autowired
    lateinit var messageService: MessageService

    @PostMapping("/message/create")
    fun messageCreate(@Valid @RequestBody messageCreateRequest: MessageCreateRequest): ResponseEntity<BaseResponse> {
        if (!messageCreateRequest.isValid()) {
            return invalidResponse()
        }

        val message = messageCreateRequest.message

        var result = false
        if (message != null) {
            result = messageService.createMessage(message)
        }

        return ResponseEntity.ok(BaseResponse(result))
    }

    @PostMapping("/message/listing")
    fun messageListing(@Valid @RequestBody messageListingRequest: MessageListingRequest): ResponseEntity<BaseResponse> {
        if (!messageListingRequest.isValid()) {
            return invalidResponse()
        }


        return ResponseEntity.ok(BaseResponse(arrayListOf("test1", "test2")))
    }

    private fun invalidResponse() = ResponseEntity.ok(BaseResponse(BaseException.Factory.invalidRequestException()))
}