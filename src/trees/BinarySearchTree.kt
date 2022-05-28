package trees

fun main() {
    val tree = BinarySearchTree<Int>()
    val list = listOf(5, 3, 2, 8, 4, 1, 7, 6)
    for (x in list) {
        tree.insert(x)
    }
    println(tree)
    println(tree.getList())
    tree.remove(5)
    println(tree)
}

class BinaryNode<T>(var value: T) : TreePrinter.PrintableNode {
    var left: BinaryNode<T>? = null
    var right: BinaryNode<T>? = null
    var parent: BinaryNode<T>? = null

    override fun toString(): String = TreePrinter.print(this)

    override fun getLeft(): TreePrinter.PrintableNode? {
        return left
    }

    override fun getRight(): TreePrinter.PrintableNode? {
        return right
    }

    override fun getText(): String {
        return "$value"
    }
}

class BinarySearchTree<T: Comparable<T>> {
    var root: BinaryNode<T>? = null

    override fun toString(): String = root?.toString() ?: "Empty tree"

    /** Вставка в бинарное дерево */
    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        if (node == null) {
            return BinaryNode(value)
        }
        if (value < node.value) node.left = insert(node.left, value) else node.right = insert(node.right, value)
        return node
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null
        when {
            value == node.value -> {
                // 1
                if (node.left == null && node.right == null) {
                    return null
                }
                if (node.left == null) {
                    return node.right
                }
                if (node.right == null) {
                    return node.left
                }
                node.right = remove(node.right, node.value)
            }
            value < node.value -> node.left =
                remove(node.left, value)
            else -> node.right = remove(node.right, value)
        }
        return node
    }

    /** Сортировка */
    fun getList(): List<T> {
        return getList(root)
    }

    private fun getList(node: BinaryNode<T>?): List<T> {
        if (node == null) {
            return emptyList()
        }
        val list = mutableListOf<T>()
        val leftList = getList(node.left)
        for (x in leftList) {
            list.add(x)
        }
        list.add(node.value)
        val rightList = getList(node.right)
        for (x in rightList) {
            list.add(x)
        }
        return list
    }

    /** Присутствие элемента в дереве  */
    fun contains(value: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = if (value < current.value) {
                current.left
            } else {
                current.right
            }
        }
        return false
    }
}