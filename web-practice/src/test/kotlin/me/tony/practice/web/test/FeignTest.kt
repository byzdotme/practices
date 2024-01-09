package me.tony.practice.web.test

import me.tony.practice.web.client.DemoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
class FeignTest {

    @Autowired
    private lateinit var service: DemoService

    @Test
    fun test() {
        val foo = service.foo()
        assertNotNull(foo)
        assertEquals(HttpStatus.OK.value(), foo.code)
    }

}