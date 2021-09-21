package me.tony.practice.web.biz

import org.springframework.boot.logging.LoggingSystem
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * @author tony.zhuby
 * @date 2020/12/18
 */
@Component
class LoggerTest :ApplicationContextAware {
    override fun setApplicationContext(ac: ApplicationContext) {
        val bean = ac.getBean(LoggingSystem::class.java)
        println(bean)
    }
}