package me.tony.practice.web.biz

import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */
@Component
class Utils : InitializingBean {

    @Autowired
    lateinit var request: HttpServletRequest

    override fun afterPropertiesSet() {
        println(request)
    }

    fun content(): String {
        return "hello world"
    }

    fun content(str: String?): String {
        return str ?: "a"

    }
}