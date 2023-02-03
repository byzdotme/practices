package me.tony.practice.web.model

import com.fasterxml.jackson.annotation.JsonFormat

class Foo {
    @field:JsonFormat(pattern = "##.0")
    var foo: Double? = null
}