package ru.touchin.pagination.entity.models

import com.fasterxml.jackson.annotation.JsonProperty

class Greeting(identifier: Int, greeting: String) {

    @JsonProperty("id")
    val identifier = identifier

    @JsonProperty("greeting")
    val greeting = greeting
}