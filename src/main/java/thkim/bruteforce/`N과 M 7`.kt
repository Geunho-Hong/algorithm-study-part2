package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val inputArr = readLine().split(' ').map { it.toInt() }.toIntArray().sorted()
    val arr = IntArray(M)
    val sb = StringBuilder()

    fun recursion(depth: Int = 0) {
        if (depth == M) {
            arr.forEach { sb.append(it).append(' ') }
            sb.append('\n')
            return
        }

        loop@ for (i in 0 until N) {
            arr[depth] = inputArr[i]
            recursion(depth + 1)
        }
    }

    recursion()
    println(sb)
}