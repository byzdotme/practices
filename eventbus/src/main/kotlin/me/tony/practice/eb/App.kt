package me.tony.practice.eb

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool

/**
 * @author tony.zhuby
 * @date 2020/12/23
 */


fun main() {
    val p = ForkJoinPool(4)
    val eb = EventBus()
    eb.register(MyListener())
    p.execute {
        eb.post(Event("foo"))
    }
    Scanner(System.`in`).nextLine()
}

data class Event(
    val event: String
)

class MyListener {
    @Subscribe
    fun processEvent(event: Event) {
        println("received event:${event.event}")
    }
}