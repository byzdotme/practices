package me.tony.practice.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.tony.practice.web.client.Foo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.ArrayList

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
class AppMain

fun main(args: Array<String>) {
    runApplication<AppMain>(*args)
    val lst = ArrayList<String>()
    lst.toString()
}