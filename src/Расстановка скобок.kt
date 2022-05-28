import java.util.Stack

fun main() {
    val stroka = "(){}{[]}"
    val stack = Stack<Char>()
    var k = true
    if (stroka.length % 2 == 0) {
        for (element in stroka) {
            when (element) {
                '(', '[', '{' -> stack.push(element)
                ')', ']', '}' -> {
                    if (stack.isEmpty()) {
                        k = false
                        break
                    }
                    val temp = stack.pop()
                    if (((temp == '(') and (element == ')')) ||
                        ((temp == '[') and (element == ']')) ||
                        ((temp == '{') and (element == '}')))
                        k = true
                    else {
                        k = false
                        break
                    }
                }
            }
        }
        if ((k) and (stack.isEmpty())){
            println("Правильная комбинация!")
        } else println("Неправильная комбинация!")
    } else println("Неправильная комбинация!")
}

