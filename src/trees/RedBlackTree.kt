package trees

fun main() {
    val tree = RedBlackTree<Int>()
    val list = listOf(5, 3, 2, 8, 4, 1, 7, 6)
    for (x in list) {
        tree.insert(x)
    }
    println(tree)
}

enum class RedBlackColor {
    RED, BLACK
}

class RedBlackNode<T>(var value: T, var color: RedBlackColor): TreePrinter.PrintableNode {
    var left: RedBlackNode<T>? = null
    var right: RedBlackNode<T>? = null
    var parent: RedBlackNode<T>? = null

    fun rotateRight(): RedBlackNode<T>? {
        val y = this
        val p = y.parent
        val x = y.left
        val b = x?.right
        if (y == p?.left) {
            p.left = x
        }
        if (y == p?.right) {
            p.right = x
        }
        x?.parent = p
        x?.right = y
        y.parent = x
        y.left = b
        b?.parent = y
        return x
    }

    fun rotateLeft(): RedBlackNode<T>? {
        val x = this
        val p = x.parent
        val y = x.right
        val b = y?.left
        if (x == p?.left) {
            p.left = y
        }
        if (x == p?.right) {
            p.right = y
        }
        y?.parent = p
        y?.left = x
        x.parent = y
        x.right = b
        b?.parent = x
        return y
    }

    override fun toString(): String = TreePrinter.print(this)

    override fun getLeft(): TreePrinter.PrintableNode? {
        return left
    }

    override fun getRight(): TreePrinter.PrintableNode? {
        return right
    }

    override fun getText(): String {
        val text = when (color) {
            RedBlackColor.RED -> "$value"
            RedBlackColor.BLACK -> "$value"
        }
        return text
    }
}

class RedBlackTree<T: Comparable<T>> {
    var root: RedBlackNode<T>? = null

    override fun toString(): String = root?.toString() ?: "Empty tree"

    fun rotateRight(node: RedBlackNode<T>) {
        if (node == root) {
            root = node.rotateRight()
        } else {
            node.rotateRight()
        }
    }

    fun rotateLeft(node: RedBlackNode<T>) {
        if (node == root) {
            root = node.rotateLeft()
        } else {
            node.rotateLeft()
        }
    }

    fun insert(value: T) {
        if (root == null) {
            root = RedBlackNode(value, RedBlackColor.BLACK)
        } else {
            insert(root!!, value)
        }
    }

    private fun insert(node: RedBlackNode<T>, value: T) {
        if (value < node.value) {
            if (node.left == null) {
                val newNode = RedBlackNode(value, RedBlackColor.RED)
                newNode.parent = node
                node.left = newNode
                balance(newNode)
            } else {
                insert(node.left!!, value)
            }
        } else {
            // T? -> T
            // x -> x!!
            if (node.right == null) {
                val newNode = RedBlackNode(value, RedBlackColor.RED)
                newNode.parent = node
                node.right = newNode
                balance(newNode)
            } else {
                insert(node.right!!, value)
            }
        }
    }

    private fun balance(x: RedBlackNode<T>) {
        val p = x.parent
        if (p == null) {
            x.color = RedBlackColor.BLACK
            return
        }
        if (p.color == RedBlackColor.BLACK) {
            return
        }
        val g = p.parent
        if (g == null) {
            balance(p)
            return
        }
        val u = if (p == g.left) {
            g.right
        } else {
            g.left
        }

        if (u?.color == RedBlackColor.RED) {
            g.color = RedBlackColor.RED
            p.color = RedBlackColor.BLACK
            u.color = RedBlackColor.BLACK
            balance(g)
            return
        }

        if (u == g.right && x == p.left) {
            rotateRight(g)
            g.color = RedBlackColor.RED
            g.parent?.color = RedBlackColor.BLACK
            return
        }

        if (u == g.right && x == p.right) {
            rotateLeft(p)
            rotateRight(g)
            g.color = RedBlackColor.RED
            g.parent?.color = RedBlackColor.BLACK
            return
        }

        if (u == g.left && x == p.right) {
            rotateLeft(g)
            g.color = RedBlackColor.RED
            g.parent?.color = RedBlackColor.BLACK
            return
        }

        if (u == g.left && x == p.left) {
            rotateRight(p)
            rotateLeft(g)
            g.color = RedBlackColor.RED
            g.parent?.color = RedBlackColor.BLACK
            return
        }
    }
}