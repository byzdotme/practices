package common

class Palindromic {
    fun countSubstrings(s: String): Int {
        return s.indices.sumOf { left ->
            s.length.downTo(left + 1).count { right -> s.subIsPalindromic(left, right) }
        }
    }
}

fun String.subIsPalindromic(start: Int = 0, endExclusive: Int = this.length): Boolean {
    return if (start >= endExclusive) false
    else if (start == endExclusive - 1) true
    else (start..<(endExclusive - start) / 2 + start).all { this[it] == this[endExclusive - 1 - it + start] }
}