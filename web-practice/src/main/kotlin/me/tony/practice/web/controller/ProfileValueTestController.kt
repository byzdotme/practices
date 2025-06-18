package me.tony.practice.web.controller

import me.tony.practice.web.app.conf.MyConf
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("profile/test")
class ProfileValueTestController {

    @Autowired
    lateinit var myConf: MyConf

    @GetMapping("myconf")
    fun test(): List<String> {
        return myConf.conf
    }
}