package thkim.stack

import java.util.*

class MakeTheStringGreat {

    fun makeGood(s: String): String {
        val stack = Stack<Char>()
        var answer = ""

        s.forEach {
            if (stack.isEmpty()) {
                stack.push(it)
            } else {
                if ((it.isUpperCase() && stack.peek() == it.toLowerCase()) ||
                    it.isLowerCase() && stack.peek() == it.toUpperCase()
                ) {
                    stack.pop()
                } else {
                    stack.push(it)
                }
            }
        }

        stack.forEach {
            answer += it
        }

        return answer
    }

}