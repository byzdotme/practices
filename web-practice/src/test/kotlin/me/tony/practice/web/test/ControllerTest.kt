package me.tony.practice.web.test

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import me.tony.practice.web.AppMain
import me.tony.practice.web.model.MyRequestBody
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

/**
 * @author tony.zhuby
 * @date 2020/12/8
 */
@SpringBootTest(classes = [AppMain::class], webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ControllerTest {
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun testValidateDefault() {
        val request = MockMvcRequestBuilders.post("/validation")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jacksonObjectMapper().writeValueAsString(MyRequestBody(null, null)))
        mvc.perform(request)
            .andDo { MockMvcResultHandlers.print().handle(it) }
            .andExpect { MockMvcResultMatchers.status().is4xxClientError.match(it) }
            .andReturn()
    }

    @Test
    fun testValidateA() {
        val request = MockMvcRequestBuilders.post("/validation/a")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jacksonObjectMapper().writeValueAsString(MyRequestBody(null, "bbbbbbbbbb")))
        mvc.perform(request)
            .andDo { MockMvcResultHandlers.print().handle(it) }
            .andExpect { MockMvcResultMatchers.status().isOk.match(it) }
            .andReturn()
    }

    @Test
    fun testValidateB() {
        val request = MockMvcRequestBuilders.post("/validation/b")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jacksonObjectMapper().writeValueAsString(MyRequestBody("aaa", "bbbbb")))
        mvc.perform(request)
            .andDo { MockMvcResultHandlers.print().handle(it) }
            .andExpect { MockMvcResultMatchers.status().isOk.match(it) }
            .andReturn()
    }
}