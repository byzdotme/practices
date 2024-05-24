package me.tony.practice.storm

import org.apache.storm.Config
import org.apache.storm.StormSubmitter
import org.apache.storm.spout.SpoutOutputCollector
import org.apache.storm.task.OutputCollector
import org.apache.storm.task.TopologyContext
import org.apache.storm.topology.OutputFieldsDeclarer
import org.apache.storm.topology.TopologyBuilder
import org.apache.storm.topology.base.BaseRichBolt
import org.apache.storm.topology.base.BaseRichSpout
import org.apache.storm.tuple.Fields
import org.apache.storm.tuple.Tuple
import org.apache.storm.tuple.Values
import kotlin.random.Random

class MySpout : BaseRichSpout() {

    private lateinit var collector: SpoutOutputCollector
    val random = Random(1010)

    override fun declareOutputFields(declarer: OutputFieldsDeclarer) {
        declarer.declare(Fields("random"))
    }

    override fun open(conf: MutableMap<String, Any>, context: TopologyContext, collector: SpoutOutputCollector) {
        this.collector = collector
    }

    override fun nextTuple() {
        if (::collector.isInitialized) {
            collector.emit(Values(random.nextDouble()))
        }
    }
}

class MyBolt : BaseRichBolt() {

    private lateinit var collector: OutputCollector
    private var sum = 0.0
    private var cnt = 0

    override fun declareOutputFields(declarer: OutputFieldsDeclarer) {
    }

    override fun prepare(topoConf: MutableMap<String, Any>, context: TopologyContext, collector: OutputCollector) {
        this.collector = collector
    }

    override fun execute(input: Tuple) {
        cnt++
        val data = input.getDoubleByField("random")
        sum += data
        println("sum:$sum, count:$cnt, avg:${sum / cnt}")
    }

}

fun main() {
    val builder = TopologyBuilder()
    builder.setSpout("gen-random-double", MySpout())
    builder.setBolt("sum-avg-doubles", MyBolt())
    val config = Config()
    config[Config.NIMBUS_SEEDS] = listOf("localhost")
    config[Config.NIMBUS_THRIFT_PORT] = 6627
    config.setNumWorkers(4)
    StormSubmitter.submitTopology("foo", config, builder.createTopology())
}