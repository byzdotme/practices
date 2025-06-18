package foo
import kotlinx.coroutines.*

val applicationJob = SupervisorJob()

// 2. 创建作用域实例，指定它的 Job 和默认的 Dispatcher
val applicationScope = CoroutineScope(applicationJob + Dispatchers.Default)

fun main(args: Array<String>) {
    SupervisorJob()
    runBlocking(Dispatchers.IO) {
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        delay(100)
        cancel()

    }
}