package me.tony.practice.web

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */
@SpringBootApplication
@EnableTransactionManagement
class AppMain {

    @Autowired
    lateinit var objectMapper:ObjectMapper

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AppMain>(*args)
        }
    }
}