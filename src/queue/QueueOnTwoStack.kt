package queue
import stack.StackOnArray

fun main() {
    val queue = StackQueue<Int>()
    queue.enqueue(5)
    queue.enqueue(6)
    queue.enqueue(7)
    println(queue)
}

class StackQueue<T : Any> : Queue<T> {
    private val leftStack = StackOnArray<T>()
    private val rightStack = StackOnArray<T>()

    override fun toString(): String {
        return "Left stack:\n $leftStack \n Right stack:\n $rightStack"
    }

    override val isEmpty: Boolean
        get() = leftStack.isEmpty() && rightStack.isEmpty()

    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }

    override fun peek(): T? {
        if (leftStack.isEmpty()) {
            transferElements()
        }
        return leftStack.peek()
    }

    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty()) {
            transferElements()
        }
        return leftStack.pop()
    }

    override val count: Int
        get() = TODO("Not yet implemented")
}