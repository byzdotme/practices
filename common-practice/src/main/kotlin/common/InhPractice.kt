package common

/**
 * @author tony.zhuby
 * @date 2020/12/9
 */


open class Foo {
    open val name = "foo"
    init {
        println("foo init")
    }
}

class Bar : Foo() {
    override val name = "bar"
    init {
        println("bar init")
    }
}

fun main() {
    val bar = Bar()
    test(mutableListOf(bar))
}

fun test(list: MutableList<in Foo>) {
    list.add(Bar())
    val item = list[0]
    println(item)
}