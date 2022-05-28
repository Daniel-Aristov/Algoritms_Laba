package sort

//fun main() {
//    val list = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
//    list.heapSort(comparator = )
//    print(list.joinToString())
//}
//
//private fun leftChildIndex(index: Int) = (2 * index) + 1
//private fun rightChildIndex(index: Int) = (2 * index) + 2
//
//fun <T> Array<T>.heapSort(comparator: ArrayList<Any>) {
//    this.heapify(comparator)
//    for (index in this.indices.reversed()) {
//        this.swapAt(0, index)
//        siftDown(0, index, comparator)
//    }
//}
//
//fun <T> Array<T>.swapAt(first: Int, second: Int) {
//    val aux = this[first]
//    this[first] = this[second]
//    this[second] = aux
//}
//
//fun <T> Array<T>.siftDown(
//    index: Int,
//    upTo: Int,
//    comparator: Comparator<T>
//) {
//    var parent = index
//    while (true) {
//        val left = leftChildIndex(parent)
//        val right = rightChildIndex(parent)
//        var candidate = parent
//        if (left < upTo &&
//            comparator.compare(this[left], this[candidate]) > 0
//        ) {
//            candidate = left
//        }
//        if (right < upTo &&
//            comparator.compare(this[right], this[candidate]) > 0
//        ) {
//            candidate = right
//        }
//        if (candidate == parent) {
//            return
//        }
//        this.swapAt(parent, candidate)
//        parent = candidate
//    }
//}
//
//fun <T> Array<T>.heapify(comparator: Comparator<T>) {
//    if (this.isNotEmpty()) {
//        (this.size / 2 downTo 0).forEach {
//            this.siftDown(it, this.size, comparator)
//        }
//    }
//}


