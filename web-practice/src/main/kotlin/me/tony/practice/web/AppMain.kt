package me.tony.practice.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.transaction.annotation.EnableTransactionManagement

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
}