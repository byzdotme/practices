package me.tony.practice.web.test

import me.tony.practice.web.client.DemoService
import me.tony.practice.web.client.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
@Ignore
class FeignTest {

    @Autowired
    private lateinit var service: DemoService

    @Test
    fun test() {
        val foo = service.foo()
        assertNotNull(foo)
        assertEquals(HttpStatus.OK.value(), foo.code)
    }

    @Test
    fun testWithParam() {
        val name = "tony"
        val res = service.fooParam(name)
        assertEquals("hello $name", res.data)
    }

    @Test
    fun testPost() {
        val res = service.fooPost(Request("title", "content with many characters"))
        assertNotNull(res)
        println(res)
    }

}