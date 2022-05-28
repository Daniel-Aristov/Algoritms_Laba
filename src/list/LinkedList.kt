package list

fun main() {
    val list = LinkedList<Int>()
    for (x in 10 downTo 1) {
        list.push(x)
    }
    println(list)
}

data class LinkedListNode<T>(var value: T, var next: LinkedListNode<T>? = null, var prev: LinkedListNode<T>? = null) {
    override fun toString(): String {
        if (next != null) return "$value -> ${next.toString()}"
        else return "$value"
    }
}

class LinkedList<T> {
    var head: LinkedListNode<T>? = null
    var tail: LinkedListNode<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }
    val isNotEmpty: Boolean get() = !isEmpty()

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    /** Получение головы связного списка */
    fun peek(): T? {
        return head?.value
    }

    /** Добавление в голову */
    fun push(value: T) {
        head = LinkedListNode(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    /** Добавление в хвост */
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = LinkedListNode(value = value)
        tail = tail?.next
        size++
    }

    /** Получение узла по индексу */
    fun findByIndex(index: Int): LinkedListNode<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    /** Вставка элемента после узла */
    fun insert(value: T, afterNode: LinkedListNode<T>): LinkedListNode<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = LinkedListNode(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    /** Удаление из головы */
    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    /** Удаление из хвоста */
    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--
        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    /** Удаление после узла */
    fun removeAfter(node: LinkedListNode<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }
        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }



    // ОЧЕРЕДЬ НА ОСНОВЕ СВЯЗНОГО СПИСКА

    /** Добавление элемента в очередь */
    fun enqueue(value: T) {
        if (tail == null) {
            push(value)
        } else {
            val node = LinkedListNode(value)
            tail?.next = node
            node.prev = tail
            tail = node
        }
    }

    /** Удаление элемента из очереди */
    fun dequeue(): T? = pop()
}