package common

class NQueen {
    fun solveNQueens(n: Int): List<List<String>> {
        return (0..<n).map { listOf(0 to it) }.map { resolve(it, 1, n) }.flatten()
            .map { it.map { pos -> pos.print(n) } }
    }


    fun resolve(arr: List<Pair<Int, Int>>, x: Int, n: Int): List<List<Pair<Int, Int>>> {
        if (x == n) return listOf(arr)
        val list = (0..<n).map { x to it }.filter { arr.none { test -> it.hittable(test) } }.map { arr + it }
        return if (x < n - 1)
            list.map { resolve(it, x + 1, n) }.flatten()
        else
            list
    }
}

fun Pair<Int, Int>.hittable(other: Pair<Int, Int>): Boolean {
    return first == other.first || second == other.second || first - second == other.first - other.second || first + second == other.first + other.second
}

fun Pair<Int, Int>.print(n: Int) = (0..<n).joinToString("") { if (it == second) "Q" else "." }

//data class Pos(val x: Int, val y: Int) {
//    fun hittable(other: Pos): Boolean {
//        return x == other.x || y == other.y || x - y == other.x - other.y || x + y == other.x + other.y
//    }
//
//    fun toString(n: Int) = (0..<n).joinToString("") { if (it == y) "Q" else "." }
//}