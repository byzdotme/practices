package me.tony.practice.springauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppMain

fun main(args: Array<String>) {
    runApplication<AppMain>(*args)
}