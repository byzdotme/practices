package me.tony.practice.elktry.test

import me.tony.practice.elktry.repo.EsRepo
import org.elasticsearch.client.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test

@SpringBootTest
class Tests {

    @Autowired
    lateinit var es: EsRepo

    @Test
    fun test1() {
        val req = Request("PUT", "account")
        val res = es.rest.performRequest(req)
        println(res)
    }

}