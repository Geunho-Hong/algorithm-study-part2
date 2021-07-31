package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }

    val arr = IntArray(M)
    val visited = BooleanArray(N)

    fun permutation(pivot: Int = 0) {
        if (pivot == M) {
            arr.forEach { print("$it ") }
            println()
            return
        }

        for (i in 1..N) {
            if (visited[i - 1]) continue
            visited[i - 1] = true
            arr[pivot] = i
            permutation(pivot + 1)
            visited[i - 1] = false
        }
    }

    permutation()
}
