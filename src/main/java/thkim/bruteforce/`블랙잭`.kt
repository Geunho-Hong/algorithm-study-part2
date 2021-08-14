package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val inputArr = readLine().split(' ').map { it.toInt() }

    val arr = IntArray(3)
    var gap = Int.MAX_VALUE
    var answer = Int.MIN_VALUE

    val visited = BooleanArray(N) { false }

    fun findSum(depth: Int = 0) {
        if (depth == 3) {
            val sum = arr.sum()
            if (sum > M) return

            val curGap = M - sum

            if (curGap < gap) {
                gap = curGap
                answer = sum
            }

            return
        }

        loop@ for (i in 0 until N) {
            if (visited[i]) continue@loop
            arr[depth] = inputArr[i]
            visited[i] = true
            findSum(depth + 1)
            visited[i] = false
        }
    }

    findSum()
    println(answer)
}