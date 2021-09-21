package me.tony.practice.web.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */
@RestController
class DemoController {

    @GetMapping("hello")
    fun hello(@ModelAttribute("name") name: String): String {
        return "hello $name"
    }
}