package me.tony.practice.web.app.conf

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "my")
@Component
class MyConf {
    lateinit var conf: List<String>
}