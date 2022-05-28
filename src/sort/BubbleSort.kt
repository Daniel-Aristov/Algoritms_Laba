package sort

fun main() {
    val list = arrayListOf(5, 2, 6, 7, 3, 1, 8, 4)
    println("Исходный массив: $list")
    list.bubbleSort()
}

fun <T: Comparable<T>> ArrayList<T>.bubbleSort() {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 1 until this.size) {
            if (this[i - 1] > this[i]) {      // сравнение предыдущего с текущим
                val temp = this[i-1]
                this[i-1] = this[i]
                this[i] = temp  // обмен значениями
                sorted = false
            }
        }
    }
    println("Отсортированный массив: $this")
}
