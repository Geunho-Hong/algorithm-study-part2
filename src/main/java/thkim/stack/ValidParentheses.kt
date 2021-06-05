package thkim.stack

import java.util.*

class ValidParentheses {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        fun removeCharacter(c: Char) {
            if (stack.empty()) {
                stack.push(c)
            } else {
                when (stack.peek()) {
                    '(' -> if (c == ')') {
                        stack.pop()
                        if (!stack.empty()) removeCharacter(stack.pop())
                    } else {
                        stack.push(c)
                    }

                    '{' -> if (c == '}') {
                        stack.pop()
                        if (!stack.empty()) removeCharacter(stack.pop())
                    } else {
                        stack.push(c)
                    }

                    '[' -> if (c == ']') {
                        stack.pop()
                        if (!stack.empty()) removeCharacter(stack.pop())
                    } else {
                        stack.push(c)
                    }

                    else -> stack.push(c)
                }
            }
        }

        s.forEach {
            removeCharacter(it)
        }

        return stack.empty()
    }

}