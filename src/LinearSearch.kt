fun main() {
    val array = arrayListOf(1, 1, 5, 15, 17, 19, 22, 24, 31, 31, 31, 105, 150)
    val x = 24

    for (i in 0 until array.size) {
        if (x == array[i]) print("Элемент находится на $i позиции!")
    }
}