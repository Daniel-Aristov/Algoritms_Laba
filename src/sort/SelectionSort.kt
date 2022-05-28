package sort

fun main() {
    val list = arrayListOf(3,1,5,4,2,7,6)
    list.selectionSort2()
}

fun selectionSort1(arr: ArrayList<Int>) {
    if (arr.size < 2) {
        println(arr)
        return
    }
    for (i in 0 until arr.size-1) {
        var min = i
        for (j in i+1 until arr.size) {
            if (arr[min] > arr[j]) {
                min = j
            }
        }
        if (min != i) {
            val temp = arr[min]
            arr[min] = arr[i]
            arr[i] = temp
        }
    }
    println(arr)
}

fun <T: Comparable<T>> ArrayList<T>.selectionSort2() {
    if (size < 2) {
        return
    }
    for (i in 0 until size-1){
        var min = i
        for (j in i + 1 until size) {
            if (this[min] > this[j]) {
                min = j
            }
        }
        if (min != i) {
            val buf = this[min]
            this[min] = this[i]
            this[i] = buf
        }
    }
    println(this)
}

