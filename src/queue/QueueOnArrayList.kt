package queue

fun main() {
    val queue = ArrayListQueue<Int>()
    queue.enqueue(5)
    queue.enqueue(6)
    queue.enqueue(7)
    println(queue)
    queue.dequeue()
    println(queue)
}

class ArrayListQueue<T> : Queue<T> {
    private val list = arrayListOf<T>()
    override fun toString(): String = list.toString()

    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? =
        if (isEmpty) null else list.removeAt(0)
}