package me.tony.practice.web

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

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AppMain>(*args)
        }
    }
}