package common

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


data class IndexMetaData(var index: String, var indexName: String, var indexSuffix: String)

data class RuleFactorVO(
    var factorSuffix: String,
    var factorName: String,
    var factorScopeName: String,
    var factorScope: Int,
    var factor: String
)

data class RuleConf(var ruleId: String, var indicatorCodeList: MutableList<String>)

data class BaseConf(
    var checkCode: String,
    var checkName: String,
    var circle: Int,
    var ruleConfigBOList: MutableList<RuleConf>
)

fun main() {
    val json = jacksonObjectMapper()

//    val baseConfs = json.readValue<List<BaseConf>>(File("/Users/tony/Downloads/baseconf.json"))
////    val metas = baseConfs.flatMap { it.ruleConfigBOList }.flatMap { it.indicatorCodeList }.distinct()
////        .map { IndexMetaData(it, "指标：$it", if (it.contains("rate")) "%" else "个") }
//
//    val metas = baseConfs.flatMap { it.ruleConfigBOList }.flatMap { it.indicatorCodeList }.distinct()
//        .map {
//            RuleFactorVO(
//                factor = it,
//                factorName = "指标：$it", factorSuffix = if (it.contains("rate")) "%" else "个",
//                factorScope = 1,
//                factorScopeName = "测试类型",
//            )
//        }
//    println(json.writeValueAsString(metas))
    val content = "`order_push_all_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '推单数(含取消推单)',\n" +
            "`order_push_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '推单数(不含取消)',\n" +
            "`reject_order_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '拒单数',\n" +
            "`order_overtime_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '超时未接单数',\n" +
            "`cancel_nonotice_order_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '取消不告知订单数',\n" +
            "`pick_time_over30_order_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '拣货超30分钟订单数',\n" +
            "`pick_order_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '拣货订单数(可统计到拣货时长的订单数)',\n" +
            "`out_stock_refund_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品已售完退单总数',\n" +
            "`comment_order_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '评价订单数',\n" +
            "`bad_comment_order_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '差评订单数',\n" +
            "`prod_error_refund_cnt` bigint(20) NOT NULL DEFAULT '0' COMMENT '商家少送错送导致的退款订单数',\n" +
            "`no_receive_order_cnt` bigint(10) NOT NULL DEFAULT '0' COMMENT '不接单数',\n" +
            "`no_receive_order_rate` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '不接单率',\n" +
            "`pick_time_over30_order_rate` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '拣货超时率',\n" +
            "`out_stock_refund_rate` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '缺货导致退款率',\n" +
            "`comment_order_rate` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '评价订单率',\n" +
            "`bad_comment_order_rate` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '差评订单率',\n" +
            "`poi_refund_order_rate` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '商责退单率',\n" +
            "`reject_order_rate` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '拒单率',\n" +
            "`selfdel_order_push_all_cnt_14d` bigint(20) NOT NULL DEFAULT '0' COMMENT '近14天商家自配推单数(不考虑订单是否退单)',\n" +
            "`selfdel_order_push_all_delay_cnt_14d` bigint(20) NOT NULL DEFAULT '0' COMMENT '近14天商家自配延迟订单数',\n" +
            "`selfdel_order_delay_rate` double(10,0) DEFAULT '0' COMMENT '自配送延迟率',"
    val bases = content.lines().map { it.split(" ") }
        .map {
            it.first().replace("`", "") to
                    it.last().replace("'", "").replace(",", "")
        }

    val metas = bases.map { IndexMetaData(it.first, it.second, if (it.first.contains("rate")) "%" else "单") }
    val factors = bases.map {
        RuleFactorVO(
            factor = it.first,
            factorName = it.second,
            factorSuffix = if (it.first.contains("rate")) "%" else "单",
            factorScope = 1,
            factorScopeName = "门店监测类数据指标",
        )
    }

    println(json.writeValueAsString(metas))
    println(json.writeValueAsString(factors))
}