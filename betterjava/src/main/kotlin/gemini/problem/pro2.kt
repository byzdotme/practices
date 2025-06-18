package gemini.problem

import kotlinx.coroutines.*
import java.lang.RuntimeException

// --- 模拟的函数，请勿修改 ---
suspend fun checkDatabase() {
    repeat(10) {
        delay(1000)
        println("✅ 数据库状态正常。")
    }
}

suspend fun checkMemory() {
    repeat(10) {
        delay(1200)
        println("🧠 内存使用率正常。")
    }
}

suspend fun checkThirdPartyService() {
    delay(3000)
    throw RuntimeException("❌ 无法连接到第三方服务！")
}
// --- ---

// 👇 请在这里实现你的函数 ---
fun startMonitoring() {
    // 你的代码...
    val ctx = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    } + SupervisorJob()
    val scope = CoroutineScope(ctx)
    scope.launch {
        checkDatabase()
    }
    scope.launch {
        checkMemory()
    }
    scope.launch {
        checkThirdPartyService()
    }
}

// --- 调用测试 ---
fun main() {
    startMonitoring()
    // 让主线程活足够长的时间来观察结果
    Thread.sleep(10000)
    println("监控程序运行结束。")
}