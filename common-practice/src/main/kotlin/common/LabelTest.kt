package common

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */


fun main() {
    foo()
}

fun foo() {
    (1..10).forEach {
        if (it == 5)
            //return
            return@forEach
        println(it)
    }
    println("end")
}