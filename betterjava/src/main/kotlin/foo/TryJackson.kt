package foo

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

fun main(args: Array<String>) {

    val json = """
        {"foo":"bar","baz":1}
    """.trimIndent()

    val map = jacksonObjectMapper().readValue<Map<String, Any>>(json)
    println(map)

}

