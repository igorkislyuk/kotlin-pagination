package ru.touchin.pagination.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.touchin.pagination.exceptions.BaseException
import ru.touchin.pagination.objects.BaseResponse
import ru.touchin.pagination.objects.MessageCreateRequest
import ru.touchin.pagination.objects.MessageListingRequest
import javax.validation.Valid

@RestController
class MessageController : ExceptionHandlingController() {

    @PostMapping("/message/create")
    fun messageCreate(@Valid @RequestBody messageCreateRequest: MessageCreateRequest): ResponseEntity<BaseResponse> {
        if (!messageCreateRequest.isValid()) {
            return invalidResponse()
        }

        return ResponseEntity.ok(BaseResponse(true))
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