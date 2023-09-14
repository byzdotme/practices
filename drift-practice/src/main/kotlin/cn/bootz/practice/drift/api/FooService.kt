package cn.bootz.practice.drift.api

import io.airlift.drift.annotations.ThriftField
import io.airlift.drift.annotations.ThriftMethod
import io.airlift.drift.annotations.ThriftService

@ThriftService
interface FooService {

    @ThriftMethod
    fun unboxFoo(@ThriftField(value = 1, requiredness = ThriftField.Requiredness.REQUIRED) foo: FooRequest): String
}