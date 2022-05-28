import kotlin.math.*

fun main() {
    val p1 = Point(2.0,4.0)
    val p2 = Point(8.0,3.0)
    val p3 = Point(16.0,7.0)
    val p4 = Point(5.0,10.0)
    val points = arrayOf(p1, p2, p3, p4)
    maxD(arr = points)
}

data class Point(val x: Double,val y: Double)

fun maxD(arr: Array<Point>) {
    var gyp: Double = 0.0
    for(i in 0 until (arr.size-1)) {
        for(j in i+1 until (arr.size-1)) {
            if (sqrt((arr[j].x-arr[i].x).pow(2) + (arr[j].y-arr[i].y).pow(2)) > gyp)
                gyp = sqrt((arr[j].x-arr[i].x).pow(2) + (arr[j].y-arr[i].y).pow(2))
        }
    }
    println(gyp)
}