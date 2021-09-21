package me.tony.practice.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */
@SpringBootApplication
class AppMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AppMain>(*args)
        }
    }
}