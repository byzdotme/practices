package me.tony.practice.web.sec.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class ApiController {

    @GetMapping("noauth")
    fun noauth(): String {
        return "ok"
    }

    @GetMapping("admin")
    fun admin(): String {
        return "ok"
    }

    @GetMapping("normal")
    fun normal(): String {
        return "ok"
    }
}