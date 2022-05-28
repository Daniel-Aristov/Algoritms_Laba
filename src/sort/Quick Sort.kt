package sort

fun main() {
    val list = mutableListOf(3,1,5,4,2,7,6)
    print(list.quicksortNaive())
}

fun<T: Comparable<T>> List<T>.quicksortNaive(): List<T> {
    if (this.size < 2) return this
    val pivot = this[this.size / 2]
    val less = this.filter { it < pivot }
    val equal = this.filter { it == pivot }
    val greater = this.filter { it > pivot }
    return less.quicksortNaive() + equal +
            greater.quicksortNaive()
}