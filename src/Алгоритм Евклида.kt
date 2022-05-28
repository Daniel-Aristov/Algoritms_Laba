import java.lang.Math.abs

fun main() {
    println(gcd1(16,24))
}

fun gcd1(number1: Int, number2: Int): Int {
    var a = number1
    var b = number2
    while ((a != 0) && (b != 0)) {
        if (a >= b) a %= b
        else b %= a
    }
    return a + b
}

fun gcd2(a: Int, b: Int): Int {
    return if (b == 0) a else gcd2(b, a % b)
}