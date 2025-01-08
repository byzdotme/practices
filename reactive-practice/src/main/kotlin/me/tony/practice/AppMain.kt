package me.tony.practice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AppMain>(*args)
        }
    }
}