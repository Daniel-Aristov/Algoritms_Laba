package stack
import list.LinkedList

fun main() {
    val stack = StackOnLinkedList<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack)
    println(stack.peek())
    stack.pop()
    println(stack)
}


class StackOnLinkedList<T : Any>() {
    val list = LinkedList<T>()

    override fun toString(): String {
        if (list.isEmpty()) {
            return "Empty list"
        } else {
            return list.toString()
        }
    }

    fun isEmpty(): Boolean? {
        return null
    }
    val isNotEmpty: Boolean get() = !isEmpty()!!

    /** Получение вершины стека */
    fun peek(): T? {
        return list.peek()
    }

    /** Добавление элемента в стек */
    fun push(value: T) {
        return list.push(value)
    }

    /** Удаление элемента из стека */
    fun pop(): T? {
        if (list.isEmpty()) {
            return null
        }
        return list.pop()
    }
}