package me.tony.practice.application.ui

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class DemoController {

    @GetMapping("get")
    fun get() :Mono<String> {
        return Mono.just("hello")
    }

}