package me.tony.practice.web.controller

import me.tony.practice.web.model.WebApiResult
import me.tony.practice.web.model.ex.MyEx1
import me.tony.practice.web.model.ex.MyEx2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author tony.zhuby
 */
@RestController
@RequestMapping("ex")
class ExController {

    @GetMapping("ex1")
    fun ex1(): WebApiResult<Any> {
        throw MyEx1()
    }

    @GetMapping("ex2")
    fun ex2(): WebApiResult<Any> {
        throw MyEx2()
    }
}