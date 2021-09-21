package me.tony.practice.web.web.advice

import me.tony.practice.web.model.WebApiResult
import org.springframework.http.HttpStatus
import org.springframework.ui.Model
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.*
import javax.validation.ValidationException

/**
 * @author tony.zhuby
 * @date 2020/12/7
 */
@ControllerAdvice
class MyAdvice {

    @ModelAttribute
    fun setup(@CookieValue(name = "token", required = false) token: String?, model: Model) {
        token?.also {
            model.addAttribute("token", it)
            model.addAttribute("name", "token:$it")
        } ?: run {
            model.addAttribute("token", "empty")
            model.addAttribute("name", "empty token")
        }
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleException(ex: Exception): WebApiResult<*> {
        return WebApiResult<Any>(code = HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.localizedMessage)
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleValidationException(ex: ValidationException): WebApiResult<*> {
        return WebApiResult<Any>(code = HttpStatus.BAD_REQUEST.value(), ex.message ?: "not valid")
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleBindException(ex: BindException): WebApiResult<*> {
        if (ex.bindingResult.hasErrors()) {
            return WebApiResult<Any>(
                HttpStatus.BAD_REQUEST.value(),
                "bind result errors",
                ex.bindingResult.allErrors.mapNotNull { it.defaultMessage }.toList()
            )
        }
        return WebApiResult<Any>(HttpStatus.BAD_REQUEST.value(), ex.message)
    }
}