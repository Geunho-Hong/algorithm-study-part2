package thkim.week1003

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

// Upper Bound, Lower Bound 개념 : https://st-lab.tistory.com/269
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (K, N) = readLine().split(' ').map(String::toInt)
    val lanList = Array(K) { 0L }

    var left = 0L
    var right = 0L

    for (i in 0 until K) {
        lanList[i] = readLine().toLong()
        right = max(right, lanList[i])
    }

    right++ // 0 ~ max + 1 범위에서 탐색해야한다.

    while (left < right) {
        val mid = (left + right) / 2

        if (canCutLan(lanList, mid, N)) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    println(left - 1)
}

private fun canCutLan(lanList: Array<Long>, lanDistance: Long, requiredCount: Int): Boolean {
    var cuttingCount = 0L

    lanList.forEach { distance ->
        cuttingCount += distance / lanDistance
        if (cuttingCount >= requiredCount) return true
    }

    return false
}