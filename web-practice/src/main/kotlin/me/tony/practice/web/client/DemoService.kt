package me.tony.practice.web.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "foo-service", url = "\${foo.service.url}")
interface DemoService {

    @GetMapping("foo")
    fun foo(): Result<Foo>
}