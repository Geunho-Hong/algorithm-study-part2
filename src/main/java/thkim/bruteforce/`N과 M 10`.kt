package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val inputArr = readLine().split(' ').map { it.toInt() }.toIntArray().sorted()
    val arr = IntArray(M)
    val answer = LinkedHashSet<String>()
    val visited = BooleanArray(N) { false }

    fun recursion(pivot: Int = 0, depth: Int = 0) {
        if (depth == M) {
            val sb = StringBuilder()
            arr.forEach { sb.append(it).append(' ') }
            answer.add(sb.toString())
            return
        }

        loop@ for (i in pivot until N) {
            if (visited[i]) continue@loop
            arr[depth] = inputArr[i]
            visited[i] = true
            recursion(i, depth + 1)
            visited[i] = false
        }
    }

    recursion()
    answer.forEach {
        println(it)
    }
}