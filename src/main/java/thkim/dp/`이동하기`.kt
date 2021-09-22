package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    val map = Array(n + 1) { IntArray(m + 1) }

    for (i in 1..n) {
        val data = readLine().split(' ').map { it.toInt() }
        for (j in 1..m) {
            map[i][j] = data[j - 1]

            map[i][j] += max(map[i][j - 1], max(map[i - 1][j], map[i - 1][j - 1]))
        }
    }

    println(map[n][m])
}
