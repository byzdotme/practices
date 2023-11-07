package cn.bootz.practice.drift

import cn.bootz.practice.drift.api.FooRequest
import cn.bootz.practice.drift.api.FooService
import io.airlift.drift.codec.ThriftCodecManager
import io.airlift.drift.codec.internal.reflection.ReflectionThriftCodecFactory
import io.airlift.drift.server.DriftServer
import io.airlift.drift.server.DriftService
import io.airlift.drift.server.stats.NullMethodInvocationStatsFactory
import io.airlift.drift.transport.netty.server.DriftNettyServerConfig
import io.airlift.drift.transport.netty.server.DriftNettyServerTransportFactory

class FooServiceImpl : FooService {
    override fun unboxFoo(foo: FooRequest): String {
        println("received foo:$foo")
        return foo.foo ?: ""
    }
}

fun main() {
    val server = DriftServer(
        DriftNettyServerTransportFactory(DriftNettyServerConfig().setPort(8411)),
        codecManager,
        NullMethodInvocationStatsFactory(),
        mutableSetOf(DriftService(FooServiceImpl())),
        mutableSetOf()
    )
    server.start()

    while (true) {
        val cmd = readln()
        if (cmd == "quit") {
            server.shutdown()
            break
        }
    }
}