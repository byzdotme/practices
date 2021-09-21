package me.tony.practice.web.web

import org.springframework.web.bind.annotation.ModelAttribute

/**
 * @author tony.zhuby
 * @date 2020/12/7
 */
abstract class AttributeSetter {

    @ModelAttribute("foo")
    fun foo(): String {
        return "bar"
    }
}