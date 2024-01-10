package me.tony.practice.web.controller

import jakarta.validation.Valid
import me.tony.practice.web.model.Foo
import me.tony.practice.web.model.GroupA
import me.tony.practice.web.model.MyRequestBody
import me.tony.practice.web.model.WebApiResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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

    @GetMapping("foo")
    fun foo(): WebApiResult<Foo> {
        val foo = Foo()
        foo.foo = 10.0
        return WebApiResult(data = foo)
    }

    @GetMapping("foo_with_param")
    fun foo(@RequestParam("param") param: String): WebApiResult<String> = WebApiResult(data = "hello $param")

    @PostMapping("foo")
    @Validated(GroupA::class)
    fun fooPost(@RequestBody @Valid body: MyRequestBody): WebApiResult<String> =
        WebApiResult(data = "title:${body.title}\ncontent:${body.content}")
}