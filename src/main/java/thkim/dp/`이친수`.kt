package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { LongArray(2) }

    dp[1][0] = 0
    dp[1][1] = 1

    for (i in 2..n) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
        dp[i][1] = dp[i - 1][0]
    }

    println(dp[n][0] + dp[n][1])
}