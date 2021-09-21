package me.tony.practice.web.controller

import me.tony.practice.web.model.GroupA
import me.tony.practice.web.model.GroupB
import me.tony.practice.web.model.MyRequestBody
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author tony.zhuby
 * @date 2020/12/8
 */
@RestController
@RequestMapping("validation")
class ValidController {

    @PostMapping
    fun defaultGroup(@RequestBody @Validated request: MyRequestBody): String {
        return "ok"
    }

    @PostMapping("a")
    fun aGroup(@RequestBody @Validated(GroupA::class) request: MyRequestBody): String {
        return "ok"
    }

    @PostMapping("b")
    fun bGroup(@RequestBody @Validated(GroupB::class) request: MyRequestBody): String {
        return "ok"
    }
}