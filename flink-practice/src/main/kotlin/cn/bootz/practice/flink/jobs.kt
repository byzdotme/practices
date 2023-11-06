package cn.bootz.practice.flink

import org.apache.flink.api.common.state.ValueState
import org.apache.flink.api.common.state.ValueStateDescriptor
import org.apache.flink.api.common.typeinfo.Types
import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.functions.KeyedProcessFunction
import org.apache.flink.table.api.Expressions.`$`
import org.apache.flink.table.api.Table
import org.apache.flink.util.Collector

class Detector : KeyedProcessFunction<String, RequestEntity, ResponseEntity>() {

    @Transient
    var state: ValueState<Boolean>? = null

    override fun open(parameters: Configuration?) {
        val des = ValueStateDescriptor<Boolean>("flag", Types.BOOLEAN)
        state = runtimeContext.getState(des)
    }

    override fun processElement(value: RequestEntity, ctx: Context, out: Collector<ResponseEntity>) {
        out.collect(ResponseEntity(value.id))
    }

}

class Job {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val env = StreamExecutionEnvironment.getExecutionEnvironment()
        }
    }

    fun foo(table: Table) {
        table.select(`$`("key"), `$`("time").floor().avg())
    }
}