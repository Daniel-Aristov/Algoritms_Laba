package sort

//fun main() {
//    val list = mutableListOf(8,3,1,5,4,2,7,6)
//    list.radixSort()
//}
//
//fun MutableList<Int>.radixSort() {
//    val base = 10
//    var done = false
//    var digits = 1
//    while (!done) {
//        val buckets = arrayListOf<MutableList<Int>>().apply {
//            for(i in 0..9) {
//                this.add(arrayListOf())
//            }
//        }
//        this.forEach {
//                number ->
//            val remainingPart = number / digits
//            if (remainingPart > 0) {
//                done = false
//            }
//            val digit = remainingPart % base
//            buckets[digit].add(number)
//        }
//        digits *= base
//        this.clear()
//        this.addAll(buckets.flatten())
//    }
//    print("Отсортированный массив: $this")
//}