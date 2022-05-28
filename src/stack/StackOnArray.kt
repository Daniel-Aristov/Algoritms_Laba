package stack

fun main() {
    val stack = StackOnArray<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.pop()
    println(stack)
    println(stack.peek())
    println(stack.count)
}

class StackOnArray<T : Any>() {
    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    private var size = 0
    fun isEmpty(): Boolean {
        return size == 0
    }
    val isNotEmpty: Boolean get() = !isEmpty()

    /** Получение вершины стека */
    fun peek(): T? {
        return storage.lastOrNull()
    }

    /** Получение глубины стека */
    val count: Int
        get() = storage.size

    /** Добавление элемента в стек */
    fun push(value: T) {
        storage.add(value)
    }

    /** Удаление элемента из стека */
    fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }
}


