package common

/**
 * @author tony.zhuby
 * @date 2020/11/30
 */


fun maxSegment(array: IntArray): Map<String, Number> {
    var start = 0
    var maxStart = 0
    var maxEnd = 0
    var sum = 0L
    var max = Long.MIN_VALUE

    for (i in array.indices) {
        sum += array[i]
        if (sum < 0) {
            if (array[i] > max) {
                start = i
                maxStart = i
                maxEnd = i
                max = array[i].toLong()
                sum = array[i].toLong()
            } else {
                start = i + 1
                sum = 0
            }
        } else if (sum > max) {
            max = sum
            maxStart = start
            maxEnd = i
        }
    }
    return mapOf("start" to maxStart, "end" to maxEnd, "sum" to max)
}

fun main() {
    val array = intArrayOf(-5, 1, 0, -1, 1, -4, -2, -4, -1, -4, -5, -2)
    println(maxSegment(array))
}