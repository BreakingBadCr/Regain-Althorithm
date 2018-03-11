package T020

import java.util.*

fun main(args: Array<String>) {

}

class KSolution {

    fun isValid(s: String): Boolean {
        if (s.isEmpty() || s.length == 1) return false
        val stack = Stack<Char>()
        for (c in s.toCharArray()) {
            if (stack.isNotEmpty()) {
                if ((c == ')' && stack.peek() == '('
                        || c == '}' && stack.peek() == '{'
                        || c == ']' && stack.peek() == '[')) {
                    stack.pop()
                } else {
                    return false
                }
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }

}