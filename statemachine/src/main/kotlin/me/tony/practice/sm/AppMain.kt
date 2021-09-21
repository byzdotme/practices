package me.tony.practice.sm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.statemachine.config.EnableStateMachine
import org.springframework.statemachine.config.EnableStateMachineFactory
import org.springframework.statemachine.config.EnableWithStateMachine

/**
 * @author tony.zhuby
 * @date 2020/12/23
 */
@SpringBootApplication
@EnableStateMachine
@EnableStateMachineFactory
class AppMain {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AppMain>(*args)
        }
    }
}