package common

class Solution {

    fun merge(A: IntArray, m: Int, B: IntArray, n: Int) {
        var a = m - 1
        var b = n - 1
        var i = m + n - 1
        while (i >= 0) {
            if (a < 0) A[i--] = B[b--]
            else if (b < 0) A[i--] = A[a--]
            else A[i--] = if (A[a] > B[b]) A[a--] else B[b--]
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var A = intArrayOf(4, 5, 6, 0, 0, 0)
            var B = intArrayOf(1, 2, 3)
            Solution().merge(A, 3, B, 3)
            println(A.contentToString())

            A = intArrayOf(1, 5, 7, 10, 12, 13, 0, 0, 0, 0)
            B = intArrayOf(6, 7, 11, 13)
            Solution().merge(A, 6, B, 4)
            println(A.contentToString())
        }
    }
}