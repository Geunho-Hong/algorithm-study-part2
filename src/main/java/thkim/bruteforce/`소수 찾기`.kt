package thkim.bruteforce

import kotlin.math.sqrt

fun main() {
    val s = `소수 찾기`()
    s.solution("011")
}

class `소수 찾기` {
    fun solution(numbers: String): Int {
        val answer = LinkedHashSet<Int>()
        val numsArr = numbers.map { Character.getNumericValue(it) }.toIntArray()
        val arr = IntArray(numbers.length) { -1 }

        fun checkMinority(num: Int) {
            if (num <= 1) return

            for (i in 2..sqrt(num.toDouble()).toInt()) {
                if (num % i == 0) return
            }

            answer.add(num)
        }

        fun recursion(depth: Int = 0, target: Int, visited: BooleanArray) {
            if (depth == target) {
                var str = ""
                for (i in 0 until target) {
                    str += arr[i]
                }

                println(str)
                checkMinority(str.toInt())
                return
            }

            for (i in numsArr.indices) {
                if (visited[i]) continue
                arr[depth] = numsArr[i]
                visited[i] = true
                recursion(depth = depth + 1, target = target, visited = visited)
                visited[i] = false
            }

        }

        for (i in numsArr.indices) {
            recursion(target = i + 1, visited = BooleanArray(numbers.length))
        }

        return answer.size
    }
}