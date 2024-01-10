package me.tony.practice.web.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "foo-service", url = "\${foo.service.url}")
interface DemoService {

    @GetMapping("foo")
    fun foo(): Result<Foo>

    @GetMapping("foo_with_param")
    fun fooParam(@RequestParam("param") param: String): Result<String>

    @PostMapping("foo")
    fun fooPost(request: Request): Result<String>
}