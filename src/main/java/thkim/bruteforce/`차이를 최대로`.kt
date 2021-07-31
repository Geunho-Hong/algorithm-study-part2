package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.max

// Permutation
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = IntArray(N)
    val copyArr = IntArray(N)

    readLine().split(" ").forEachIndexed { idx, data -> arr[idx] = data.toInt() }

    Arrays.sort(arr)

    val visited = BooleanArray(N)
    var result: Int = Int.MIN_VALUE

    fun permutation(pivot: Int) {
        if (pivot == N) {
            var sum = 0
            for (i in 0 until N - 1) {
                sum += abs(copyArr[i] - copyArr[i + 1])
            }
            result = max(result, sum)
            return
        }

        for (i in 0 until N) {
            if (visited[i]) continue

            visited[i] = true
            copyArr[pivot] = arr[i]
            permutation(pivot + 1)
            visited[i] = false
        }
    }

    permutation(0)

    println(result)
}