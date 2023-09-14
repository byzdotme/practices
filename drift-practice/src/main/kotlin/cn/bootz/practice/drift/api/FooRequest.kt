package cn.bootz.practice.drift.api

import io.airlift.drift.annotations.ThriftField
import io.airlift.drift.annotations.ThriftStruct

@ThriftStruct
class FooRequest {

    @get:ThriftField(value = 1, requiredness = ThriftField.Requiredness.REQUIRED)
    @set:ThriftField
    var foo: String? = null

    override fun toString(): String {
        return "FooRequest(foo=$foo)"
    }

}