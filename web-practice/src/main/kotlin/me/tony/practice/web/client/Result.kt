package me.tony.practice.web.client

import org.springframework.http.HttpStatus

data class Result<T>(
    val code: Int = HttpStatus.OK.value(),
    val msg: String = HttpStatus.OK.reasonPhrase,
    val data: T? = null
)