package common

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.nio.file.Files
import java.nio.file.Paths


data class Param(val mergePairs:Map<String, List<Int>>)

fun main(args: Array<String>) {
    val content = Files.readString(Paths.get("/Users/tony/code/foo.txt"))
    val om = jacksonObjectMapper()
    val data = om.readValue<List<List<Int>>>(content, jacksonTypeRef())
    val pairs = data.filter { it.size > 1 }.associate { it.first().toString() to it.subList(1, it.size) }
    println(om.writeValueAsString(Param(pairs)))
}