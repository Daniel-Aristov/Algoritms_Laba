/*
Алгоритм преобразования инфиксного выражения в постфиксное:

Примеры:
4*(2+3)/3+5 -> 4 2 3 + * 3 / 5 +
3*2-1/2*(2+4) -> 3 2 * 1 2 / 2 4 + * -
*/

import java.util.Stack

private var stack = Stack<String>()
private var postfix = mutableListOf<String>()
private var infix = mutableListOf<String>()
private var result = Stack<Float>()

fun main() {
    print("Инфиксное выражение: ")
    getInfix()
    getPostfix()
    println(' ')
    print("Результат выражения: ")
    calcPostfix()
}

fun getInfix() {
    val stroka = readLine()
    stroka.toString()
    if (stroka != null) {
        for (element in stroka) {
            infix.add(element.toString())
        }
    }
}

fun getPostfix() {
    for (element in infix) {
        when (element) {
            "(" -> stack.push(element)

            ")" -> {
                while (infix.contains("(")) {
                    if (stack.peek() == "(") {
                        stack.pop()
                        break
                    }
                    postfix.add(stack.pop())
                }
            }

            //Если входящий элемент + или -
            "+", "-" ->
                if (stack.isEmpty() || stack.peek() == "(") stack.push(element)
                else if (stack.peek() == "*" || stack.peek() == "/") {
                    while (stack.isNotEmpty()) {
                        if (stack.peek() == "(") {
                            stack.pop()
                            break
                        }
                        postfix.add(stack.pop())
                    }
                    stack.push(element)
                } else postfix.add(stack.pop())

            //Если входящий элемент * или /
            "*", "/" -> {
                // Проверяем, если на вершине стека элемент с таким же приоритетом или старшим
                if (stack.isNotEmpty() && (stack.peek() == "*" || stack.peek() == "/")) {
                    while (stack.isNotEmpty()) { // Выводим элементы стека в результат пока не найдем левую скобку, потом удаляем скобку из стека
                        if (stack.peek() == "(") {
                            stack.pop()
                            break
                        }
                        if (stack.peek() == "*" || stack.peek() == "/") {
                            postfix.add(stack.pop())
                            break
                        }
                    }
                }
                stack.push(element)
            }

            else -> postfix.add(element)
        }
    }

    // Если стек не пустой, то добавляем в результат оставшиеся элементы стека, кроме "("
    if (stack.isNotEmpty()) {
        while (stack.isNotEmpty()) {
            if (stack.peek() != "(") {
                postfix.add(stack.pop())
            }
        }
    }

    // Выводим постфиксное выражение
    print("Постфиксное выражение: ")
    for (element in postfix) {
        print("$element ")
    }
}

fun calcPostfix() {
    for (element in postfix) {
        when (element) {
            "+" -> {
                val a = result.removeLast()
                val b = result.removeLast()
                result.add(a + b)
            }
            "*" -> {
                val a = result.removeLast()
                val b = result.removeLast()
                result.add(a * b)
            }
            "/" -> {
                val a = result.removeLast()
                val b = result.removeLast()
                result.add(b / a)
            }
            "-" -> {
                val a = result.removeLast()
                val b = result.removeLast()
                result.add(b - a)
            }
            else -> {
                result.add(element.toFloat())
            }
        }
    }
    print(result)
}