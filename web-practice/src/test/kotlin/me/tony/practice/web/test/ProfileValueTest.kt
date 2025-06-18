package me.tony.practice.web.test

import me.tony.practice.web.AppMain
import me.tony.practice.web.app.conf.MyConf
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.Test

@SpringBootTest(classes = [AppMain::class])
@ActiveProfiles(profiles = ["bar"])
class ProfileValueTest {

    @Autowired
    lateinit var myConf: MyConf

    @Test
    fun testMyConf() {
        println(myConf.conf)
    }

}