package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine().split(' ').map(String::toInt)
    val dp = Array(N + 1) { IntArray(K + 1) }

    for (i in 1 until N + 1) {
        val (W, V) = readLine().split(' ').map(String::toInt)

        for (j in 1 until K + 1) {
            if (j < W) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - W] + V)
            }
        }
    }

    println(dp[N][K])
}