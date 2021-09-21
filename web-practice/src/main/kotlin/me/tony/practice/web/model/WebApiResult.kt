package me.tony.practice.web.model

import org.springframework.http.HttpStatus

/**
 * @author tony.zhuby
 * @date 2020/12/8
 */
data class WebApiResult<T>(
    val code: Int = HttpStatus.OK.value(),
    val msg: String = HttpStatus.OK.reasonPhrase,
    val data: T? = null
)