package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

// https://youtu.be/P-mMvhfJhu8
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val first = readLine()
    val second = readLine()

    val dp = Array(second.length + 1) { IntArray(first.length + 1) }

    for (i in 1..second.length) {
        for (j in 1..first.length) {
            if (second[i - 1] != first[j - 1]) {
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
            } else {
                dp[i][j] = dp[i - 1][j - 1] + 1
            }
        }
    }

    println(dp[second.length][first.length])
}