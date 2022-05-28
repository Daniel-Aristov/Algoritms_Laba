package sort

fun main() {
    val list = arrayListOf(7,2,1,3,5,4,6)
    list.insertionSort2()
    println(list)
}

fun insertionSort1(arr: ArrayList<Int>) {
    if (arr.size < 2) {
        println(arr)
        return
    }
    for (i in 1 until arr.size) {
        for (j in i downTo 1) {
            if (arr[j-1] > arr[j]){
                val temp = arr[j-1]
                arr[j-1] = arr[j]
                arr[j] = temp
            } else
                break
        }
    }
    println(arr)
}

fun <T: Comparable<T>> ArrayList<T>.insertionSort2() {
    if (size < 2) {
        return
    }
    for (i in 1 until size) {
        for (j in i downTo 1) {
            if (this[j-1] > this[j]) {
                val temp = this[j-1]
                this[j-1] = this[j]
                this[j] = temp
            } else {
                break
            }
        }
        println(this)
    }
}