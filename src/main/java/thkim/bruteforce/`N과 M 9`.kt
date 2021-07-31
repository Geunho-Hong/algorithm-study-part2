package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val inputArr = readLine().split(' ').map { it.toInt() }.toIntArray().sorted()
    val arr = IntArray(M)
    val answer = LinkedHashSet<String>()
    val visited = BooleanArray(N) { false }

    fun recursion(depth: Int = 0) {
        if (depth == M) {
            val sb = StringBuilder()
            arr.forEach { sb.append(it).append(' ') }
            answer.add(sb.toString())
            return
        }

        loop@ for (i in 0 until N) {
            if (visited[i]) continue@loop
            arr[depth] = inputArr[i]
            visited[i] = true
            recursion(depth + 1)
            visited[i] = false
        }
    }

    recursion()
    answer.forEach {
        println(it)
    }
}