package gemini.problem

import kotlinx.coroutines.*

// --- 模拟的函数，请勿修改 ---
suspend fun loadDataFromNetwork(): String {
    println("阶段1: 正在加载网络数据...")
    delay(2000) // 模拟长时间的I/O操作
    return "这是原始数据"
}

// --- 改造后的 transformData ---
suspend fun transformDataCooperative(data: String): String {
    println("阶段2: 开始进行CPU密集型计算...")
    // withContext 确保即使外面是单线程Dispatcher，这里也能切换到计算线程池
    return withContext(Dispatchers.Default) {
        var transformed = ""
        for (i in 1..100) {
            // 关键点1：检查协程是否还活着！
            if (!isActive) {
                // 如果已经被取消，可以立即跳出或抛出异常
                throw CancellationException("计算过程被取消")
            }
            // 关键点2：用 delay 或 yield 代替 Thread.sleep
            // delay(50) // 如果需要暂停，用非阻塞的delay
            // 或者只是为了让出线程，检查取消信号
            yield() // 推荐！它会检查取消状态，并让出CPU给其他协程
            transformed += data[i % data.length]
        }
        transformed
    }
}

// --- processData 函数现在可以写得很简洁 ---
fun CoroutineScope.processData() = launch {
    try {
        val data = loadDataFromNetwork()
        val processedData = transformDataCooperative(data) // 直接调用改造后的挂起函数
        println("处理完成: $processedData")
    } finally {
        println("清理工作完成。")
    }
}

// --- 调用测试 ---
fun main() = runBlocking {
    val job = processData() // 在当前作用域启动任务

    delay(2500) // 让它运行一会儿
    println("主线程：任务时间太长，发出取消指令！")
    job.cancelAndJoin() // 取消任务并等待它完成

    println("主线程：确认任务已取消。")
}