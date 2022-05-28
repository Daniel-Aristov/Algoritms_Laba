fun main () {
    val array = arrayListOf(1, 1, 1, 5, 15, 17, 19, 22, 24, 31, 31, 31, 105, 150, 150, 150)
    val x = 150
    println(array.binarySearch(x))

    // Поиск диапазона индексов повторяющегося элемента
    val start = array.searchStartIndex(x)
    val end = array.searchEndIndex(x)
    println("Диапазон индексов элемента $x: $start..$end")
}

fun <T : Comparable<T>> ArrayList<T>.binarySearch(value: T, range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    return when {
        this[middle] == value -> middle
        this[middle] > value -> binarySearch(value, range.first until
                middle)
        else -> binarySearch(value, (middle + 1)..range.last)
    }
}

/** Бинарный поиск первого из повторяющихся элемента в массиве */
fun <T: Comparable<T>>ArrayList<T>.searchStartIndex(value: T, range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        if (middle == range.first) {
            return middle
        }
        return if (value == this[middle - 1]) {
            searchStartIndex(value, range.first until middle)
        } else {
            middle
        }
    }
    return if (value < this[middle]) {
        searchStartIndex(value, range.first until middle)
    } else {
        searchStartIndex(value, middle + 1..range.last)
    }
}

/** Бинарный поиск последнего из повторяющихся элемента в массиве */
fun <T: Comparable<T>>  ArrayList<T>.searchEndIndex(value: T,
                                              range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        if (middle == range.last) {
            return range.last
        }
        if (this[middle + 1] != value) {
            return middle
        } else {
            searchEndIndex(value, middle + 1..range.last)
        }
    }
    if (value < this[middle]) {
        return searchEndIndex(value, range.first until middle)
    } else {
        return searchEndIndex(value, middle + 1..range.last)
    }
}