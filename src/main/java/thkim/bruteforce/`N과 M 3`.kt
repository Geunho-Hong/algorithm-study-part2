package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(M)
    val sb = StringBuilder()

    fun recursion(depth: Int = 0) {
        if (depth == M) {
            arr.forEach { sb.append(it).append(' ') }
            sb.append('\n')
            return
        }

        for (i in 1..N) {
            arr[depth] = i
            recursion(depth + 1)
        }
    }

    recursion()
    println(sb)
}