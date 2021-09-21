package me.tony.practice.elktry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author tony.zhuby
 * @date 2021/7/6
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