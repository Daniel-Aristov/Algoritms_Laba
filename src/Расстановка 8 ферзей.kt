import kotlin.math.abs

fun main() {
    println("Queens")
    val n = 8
    val board = mutableListOf<Int>()
    var isExpandable = true
    var solution = 1
    while (board.isNotEmpty() || isExpandable) {
        if (board.size == n) {
            println("Решение $solution: $board")
            solution++
        }
        var isExpandSuccess = false
        if (isExpandable) {
            for (x0 in 0 until n) {
                if (isValid(x0, board)) {
                    board.add(x0)
                    isExpandSuccess = true
                    isExpandable = true
                    break
                }
            }
        }
        if (!isExpandSuccess) {
            var isChangeSuccess = false
            val last = board.removeLastOrNull() ?: -1
            for (x0 in (last + 1) until n) {
                if (isValid(x0, board)) {
                    board.add(x0)
                    isChangeSuccess = true
                    isExpandable = true
                    break
                }
            }
            if (!isChangeSuccess) {
                isExpandable = false
            }
        }
    }
}

fun isValid(x0: Int, board: List<Int>): Boolean {
    val i0 = board.size
    for ((i, x) in board.withIndex()) {
        if (x == x0 || abs(i - i0) == abs(x - x0)) {
            return false
        }
    }
    return true
}