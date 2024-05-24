package me.tony.practice.web.controller

import me.tony.practice.web.model.WebApiResult
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST])
class EchoController {

    @PostMapping("api/foo")
    fun foo(@RequestBody request: Data): WebApiResult<Data> = WebApiResult(data = Data("echo:${request.foo}"))

    data class Data(val foo: String)
}

