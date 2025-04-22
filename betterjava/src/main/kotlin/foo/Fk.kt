package foo

fun main(args: Array<String>) {
    println("select * from (")
    println((0..99).joinToString(separator = " union\n") { "select 'forex_pay_instruction_$it' as tb, count(1) as cnt from forex_pay_instruction_$it where pay_order_no='2501091052352588125'" })
    println(") as t where t.cnt > 0;")
}