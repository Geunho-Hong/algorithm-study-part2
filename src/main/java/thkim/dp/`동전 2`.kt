package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(' ').map { it.toInt() }

    val arr = IntArray(n)
    val coinList = IntArray(k + 1) { 100001 }
    coinList[0] = 0

    for (i in 0 until n) arr[i] = readLine().toInt()

    for (i in 0 until n) {
        for (j in arr[i]..k) {
            coinList[j] = min(coinList[j], coinList[j - arr[i]] + 1)
        }
    }

    if (coinList[k] == 100001) coinList[k] = -1
    println(coinList[k])
}