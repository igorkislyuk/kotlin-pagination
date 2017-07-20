package ru.touchin.pagination.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.touchin.pagination.entity.Greeting
import ru.touchin.pagination.entity.BaseResponse
import java.util.concurrent.atomic.AtomicInteger

@RestController
class GreetingController {

    private val counter = AtomicInteger()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(name = "name", defaultValue = "World") name: String): BaseResponse {
        val result = Greeting(counter.incrementAndGet(), "Hello, $name!")
        return BaseResponse(result)
    }
}