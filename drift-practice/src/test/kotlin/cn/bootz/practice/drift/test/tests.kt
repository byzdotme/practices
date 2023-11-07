package cn.bootz.practice.drift.test

import cn.bootz.practice.drift.api.FooRequest
import cn.bootz.practice.drift.client
import org.junit.jupiter.api.Test


class CommonTest {

    @Test
    fun testNullCheck() {
        val request = FooRequest()
//        request.prefix = "haha"
//        request.foo = "haha"
        val res = client.get().unboxFoo(request)
        println("result is $res")
    }
}