package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(' ').map { it.toInt() }

    val arr = IntArray(n + 1)
    val coinList = IntArray(k + 1)
    coinList[0] = 1

    for (i in 1..n) {
        arr[i] = readLine().toInt()
        for (j in arr[i]..k) {
            coinList[j] =
                coinList[j] +
                        coinList[j - arr[i]]
        }
    }

    println(coinList[k])
}