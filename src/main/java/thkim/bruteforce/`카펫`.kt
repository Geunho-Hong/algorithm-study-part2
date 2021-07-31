package thkim.bruteforce

import kotlin.math.ceil

fun main() {
    val s = `카펫`()
    s.solution(24, 24).forEach {
        println("Answer :: $it")
    }
}

class `카펫` {
    fun solution(brown: Int, yellow: Int): IntArray {
        val answer = IntArray(2)

        // yellow 의 가로 x 세로의 모든 경우의 수를 카운트.
        // 각 경우의 수 마다 가로 사이즈(yellow 가로 + 2) 세로 사이즈(yellow 세로 + 2) 계산
        // brown 의 개수를 이용해 가능한 경우를 탐색
        fun findSize(row: Int): Pair<Int, Int>? {
            val col = yellow / row

            return if (((row + 2) * (col + 2) - yellow) == brown) col to row
            else null
        }

        loop@ for (i in 1..ceil(yellow / 2.0).toInt()) {
            if (yellow % i != 0) continue
            findSize(i)?.let {
                answer[0] = it.first + 2
                answer[1] = it.second + 2
                return answer
            }
        }

        return answer
    }
}