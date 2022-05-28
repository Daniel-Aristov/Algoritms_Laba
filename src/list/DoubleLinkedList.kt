package list

fun main() {
    val list = DoubleLinkedList<Int>()
    for (x in 10 downTo 1) {
        list.push(x)
    }
    println(list)
}

data class DoubleLinkedListNode<T>(var value: T, var next: DoubleLinkedListNode<T>? = null, var prev: DoubleLinkedListNode<T>? = null) {
    override fun toString(): String {
        if (next != null) return "$value <-> ${next.toString()}"
        else return "$value"
    }
}

class DoubleLinkedList<T> {
    var head: DoubleLinkedListNode<T>? = null
    var tail: DoubleLinkedListNode<T>? = null
    private var size = 0

    override fun toString(): String {
        if (isEmpty) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    val isEmpty: Boolean get() {
        return head == null
    }
    val isNotEmpty: Boolean get() = !isEmpty

    fun peek(): T? {
        return head?.value
    }

    /** Добавление элемента в начало двусвязного списка */
    fun push(x: T) {
        val node = DoubleLinkedListNode(x)
        if (isEmpty) {
            head = node
            tail = node
            return
        }
        node.next = head
        head!!.prev = node
        head = node
        size++
    }

    /** Добавление элемента по индексу двусвязного списка */
    fun insertAtIndex(index: Int, x: T) {
        val node = DoubleLinkedListNode(x)
        if (index == 0) {
            return push(x)
        }
        val current = findByNode(index - 1)
        node.next = current?.next
        node.prev = current
        current?.next = node
        current?.next?.prev = node
        size++
    }

    /** Вставка элемента в середину двусвязного списка */
    fun insertMiddle(value: T) {
        val middle = size / 2
        var currNode = head
        var currIndex = 0

        while (currIndex < middle) {
            currNode = currNode?.next
            currIndex++
        }

        val newNode = DoubleLinkedListNode(value = value, next = currNode, prev = currNode?.prev)
        currNode?.prev = newNode
        currNode?.prev?.prev?.next = newNode
        size++
    }

    /** Добавление элемента в конец двусвязного списка */
    fun append(x: T) {
        val node = DoubleLinkedListNode(x)
        if (isEmpty) {
            head = node
            tail = node
            return
        }
        tail!!.next = node
        node.prev = tail
        tail = node
        size++
    }

    /** Удаление элемента из головы двусвязного списка */
    fun pop(): T? {
        if (isEmpty) {
            return null
        }
        val value = head?.value
        head = head?.next
        if (head == null) {
            tail = null
        } else {
            head!!.prev = null
        }
        size--
        return value
    }

    /** Удаление элемента по индексу в двусвязном списке */
    fun removeAtIndex(index: Int): T? {
        if (index == 0) {
            return pop()
        }
        val a = findByNode(index - 1)
        val b = a?.next
        val c = b?.next
        a?.next = c
        c?.prev = a
        size--
        return b?.value
    }

    /** Удаление элемента из хвоста двусвязного списка */
    fun removeLast(): T? {
        if (isEmpty) {
            return null
        }
        val value = tail!!.value
        tail = tail!!.prev
        size--
        return value
    }

    /** Удаление элемента из середины двусвязного списка */
    fun removeMiddle() {
        if (size == 2) removeLast()
        else {
            val middle = size / 2
            var currNode = head
            var currIndex = 0

            while (currIndex < middle) {
                currNode = currNode?.next
                currIndex++
            }

            currNode?.prev?.next = currNode?.next
            currNode?.next?.prev = currNode?.prev
            size--
        }
    }

    /** Поиск по узлу двусвязного списка */
    fun findByNode(index: Int): DoubleLinkedListNode<T>? {
        var node = head
        var i = 0
        while (node != null && i < index) {
            node = node.next
            i++
        }
        return node
    }



    // ОЧЕРЕДЬ НА ОСНОВЕ ДВУСВЯЗНОГО СПИСКА

    /** Добавление элемента в очередь */
    fun enqueue(value: T) {
        if (tail == null) {
            push(value)
        } else {
            val node = DoubleLinkedListNode(value)
            tail?.next = node
            node.prev = tail
            tail = node
        }
    }

    /** Удаление элемента из очереди */
    fun dequeue(): T? = pop()
}