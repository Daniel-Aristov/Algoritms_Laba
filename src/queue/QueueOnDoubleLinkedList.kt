package queue
import list.DoubleLinkedList

fun main() {
    val queue = DoubleLinkedListQueue<Int>()
    queue.enqueue(5)
    queue.enqueue(6)
    queue.enqueue(7)
    println(queue)
}

class DoubleLinkedListQueue<T>: Queue<T> {
    val queue = DoubleLinkedList<T>()

    override fun toString(): String = queue.toString()

    private var size = 0
    override val count: Int
        get() = size

    override fun peek(): T? = queue.peek()

    override fun enqueue(element: T): Boolean {
        queue.append(element)
        size++
        return true
    }

    override fun dequeue(): T? {
        TODO("Not yet implemented")
    }
}
