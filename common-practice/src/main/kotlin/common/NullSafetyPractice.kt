package common

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */

fun main() {
//    test(null as String?)
//    test("hello")
    test(listOf(1,2,3))
}

fun test(str:String?) {
    println(str?.length?:"empty")
}

fun test(list:List<*>?) {
    println(list?.firstOrNull())
}