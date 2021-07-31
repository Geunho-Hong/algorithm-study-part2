package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val inputArr = readLine().split(' ').map { it.toInt() }.toIntArray().sorted()
    val arr = IntArray(M)
    val sb = StringBuilder()

    fun recursion(pivot: Int = 0, depth: Int = 0) {
        if (depth == M) {
            arr.forEach { sb.append(it).append(' ') }
            sb.append('\n')
            return
        }

        loop@ for (i in pivot until N) {
            arr[depth] = inputArr[i]

            recursion(i, depth + 1)
        }
    }

    recursion()
    println(sb)
}