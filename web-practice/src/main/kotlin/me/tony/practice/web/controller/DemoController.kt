package me.tony.practice.web.controller

import me.tony.practice.web.model.Foo
import me.tony.practice.web.model.WebApiResult
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

    @GetMapping("foo")
    fun foo() : WebApiResult<Foo> {
        val foo = Foo()
        foo.foo = 10.0
        return WebApiResult(data = foo)
    }
}