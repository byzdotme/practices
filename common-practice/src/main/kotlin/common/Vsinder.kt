package common

/**
 * @author tony.zhuby
 * @date 2020/12/15
 */

fun MyLife.meet(you: Angel?) =
    you?.let { me ->
        "feel happy"
    } ?: "feel lonely"


class MyLife

class Angel

fun main() {
    val me = MyLife()
    println(me.meet(null))
}