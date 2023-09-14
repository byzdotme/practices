package cn.bootz.practice.drift

import cn.bootz.practice.drift.api.FooService
import io.airlift.drift.client.DriftClientFactory
import io.airlift.drift.client.address.SimpleAddressSelector
import io.airlift.drift.client.address.SimpleAddressSelectorConfig
import io.airlift.drift.codec.ThriftCodecManager
import io.airlift.drift.transport.netty.client.DriftNettyClientConfig
import io.airlift.drift.transport.netty.client.DriftNettyMethodInvokerFactory


val client = DriftClientFactory(
    ThriftCodecManager(), DriftNettyMethodInvokerFactory.createStaticDriftNettyMethodInvokerFactory(
        DriftNettyClientConfig()
    ), SimpleAddressSelector(SimpleAddressSelectorConfig().setAddresses("127.0.0.1:8411"))
).createDriftClient(FooService::class.java)