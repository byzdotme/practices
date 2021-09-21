package me.tony.practice.web.controller.advice

import me.tony.practice.web.model.WebApiResult
import me.tony.practice.web.model.ex.MyEx1
import me.tony.practice.web.model.ex.MyEx2
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author tony.zhuby
 */
@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun handleMyEx1(ex: MyEx1): WebApiResult<Any> {
        return WebApiResult()
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    fun handleMyEx2(ex: MyEx2): WebApiResult<Any> {
        return WebApiResult()
    }
}