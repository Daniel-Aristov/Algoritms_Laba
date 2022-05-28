fun main() {
    sqrt(1)  // 1
    sqrt(2)  // 1
    sqrt(9)  // 3
    sqrt(14) // 3.8 -> 3
    sqrt(257)
}

fun sqrt(n: Int) {
    var low = 1
    var high = n
    if ((n == 0) || (n == 1)) println(n)
    else {
        while (high-low > 1) {
            val mid = (low + high) / 2
            if (mid * mid <= n)
                low = mid
            else high = mid
        }
        println(low)
    }
}