package common

/**
 * @author tony.zhuby
 * @date 2020/12/14
 */

interface Base {
    val message: String
    fun print()
    fun sayHello()
}

class BaseImpl(x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() {
        println(message)
    }

    override fun sayHello() {
        println("hello from ${this.javaClass}")
    }
}

class Derived(b: Base) : Base by b {
    override val message = "Message of Derived"
    override fun sayHello() {
        println("hello from ${this.javaClass}")
    }
}

fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()
    println(derived.message)
    derived.sayHello()
}

class PropDerived {
    val name:String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        return@lazy "hello"
    }
}