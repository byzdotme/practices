package cn.bootz.practice.drift.test

import cn.bootz.practice.drift.api.FooRequest
import cn.bootz.practice.drift.client
import org.junit.jupiter.api.Test


class CommonTest {

    @Test
    fun testNullCheck() {
        val res = client.get()
            .unboxFoo(
                FooRequest()
            )
        println("result is $res")
    }
}