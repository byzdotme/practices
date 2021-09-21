package common

/**
 * @author tony.zhuby
 * @date 2020/12/11
 */
object MySingleton {
    const val greeting = "hello"
    fun greetings(name: String) {
        println("$greeting, $name")
    }
}