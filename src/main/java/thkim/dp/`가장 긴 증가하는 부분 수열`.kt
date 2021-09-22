package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = readLine().split(' ').map(String::toInt)
    val dp = IntArray(n) { 1 }

    for (i in 0 until n) for (j in 0 until i) if (arr[j] < arr[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1
    println(dp.maxOf { it })
}