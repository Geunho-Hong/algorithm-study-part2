package thkim.week0919

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map(String::toInt)
    val treeList = LongArray(N)
    val token = StringTokenizer(readLine())
    var maximum: Long = Long.MIN_VALUE

    for (i in 0 until N) {
        treeList[i] = token.nextToken().toLong()
        maximum = max(maximum, treeList[i])
    }

    var left = 0L
    var right = maximum

    while (left <= right) {
        val mid = (left + right) / 2L
        var sum = 0L

        for (tree in treeList) {
            if (tree > mid) sum += tree - mid
        }

        if (sum >= M) left = mid + 1
        else right = mid - 1
    }

    println(right)
}