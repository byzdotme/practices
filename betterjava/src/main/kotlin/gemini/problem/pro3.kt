package gemini.problem

import kotlinx.coroutines.*

// --- 模拟的函数，请勿修改 ---
suspend fun fetchApiSourceA(): String {
    delay(1000)
    return "来自A的数据"
}

suspend fun fetchApiSourceB(): String {
    delay(2000)
    throw RuntimeException("B源服务器过载")
}

suspend fun fetchApiSourceC(): String {
    delay(1500)
    return "来自C的数据"
}
// --- ---

// 👇 请在这里实现你的函数 ---
suspend fun fetchAggregatedData(): Map<String, String> {
    return supervisorScope {
        val deferredA = async { fetchApiSourceA() }
        val deferredB = async { fetchApiSourceB() }
        val deferredC = async { fetchApiSourceC() }

        val deferreds = mapOf(
            "A" to deferredA,
            "B" to deferredB,
            "C" to deferredC
        )

        // 使用 mapValues 来转换 Map，保持并行性
        deferreds.mapValues { (_, deferred) ->
            try {
                deferred.await() // 在这里等待每个结果
            } catch (e: Exception) {
                "Error: ${e.message}"
            }
        }
    }
}

// --- 调用测试 ---
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val report = fetchAggregatedData()
    println("耗时: ${System.currentTimeMillis() - startTime}ms")
    println("\n聚合报告:")
    report.forEach { (source, result) ->
        println("- $source: $result")
    }
}