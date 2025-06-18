package gemini.problem

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.select

// --- 模拟的函数，请勿修改 ---
suspend fun fetchFromPrimaryServer(): String {
    delay(1500) // 主服务器通常快一些
    return "来自主服务器的配置"
}

suspend fun fetchFromBackupServer(): String {
    delay(2500) // 备用服务器慢一些
    return "来自备用服务器的配置"
}
// --- ---

// 👇 请在这里实现你的函数 ---
suspend fun fetchFastestConfig(): String {
    return withTimeout(2000) { // 1. 设置一个总的超时时间
        coroutineScope { // 2. 创建一个作用域来管理两个子任务
            val deferredPrimary = async { fetchFromPrimaryServer() }
            val deferredBackup = async { fetchFromBackupServer() }

            // 3. 使用 select 参加比赛
            val result = select<String> {
                // 谁先 await 成功，select 就返回谁的结果
                deferredPrimary.onAwait { config ->
                    deferredBackup.cancel() // 关键：立即取消另一个
                    "主服务器获胜: $config"
                }
                deferredBackup.onAwait { config ->
                    deferredPrimary.cancel() // 关键：立即取消另一个
                    "备用服务器获胜: $config"
                }
            }
            result // 返回 select 的结果
        }
    }
}

// --- 调用测试 ---
fun main() = runBlocking {
    try {
        println("开始获取最快配置...")
        val config = fetchFastestConfig()
        println("成功获取配置: $config")
    } catch (e: Exception) {
        println("获取配置失败: ${e.message}")
    }
}