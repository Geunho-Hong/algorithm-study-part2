package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }

    val house = arrayListOf<Pair<Int, Int>>()
    val chicken = arrayListOf<Pair<Int, Int>>()
    val visited = BooleanArray(13)

    var result = Int.MAX_VALUE

    for (i in 0 until N) {
        val data = readLine().split(' ').map { it.toInt() }
        for (j in 0 until N) {
            if (data[j] == 1) {
                house.add(i to j)
            } else if (data[j] == 2) {
                chicken.add(i to j)
            }
        }
    }

    fun calDistance(x: Pair<Int, Int>, y: Pair<Int, Int>) =
        abs(x.first - y.first) + abs(x.second - y.second)

    fun findMinDistance(pivot: Int = 0, depth: Int = 0) {
        if (depth == M) {
            var tempResult = 0
            for (i in house.indices) {
                var distance = Int.MAX_VALUE
                for (j in chicken.indices) {
                    if (visited[j]) distance = min(distance, calDistance(house[i], chicken[j]))
                }

                tempResult += distance
            }
            result = min(result, tempResult)

            return
        }

        if (pivot == chicken.size) return

        visited[pivot] = true
        findMinDistance(pivot + 1, depth + 1)
        visited[pivot] = false
        findMinDistance(pivot + 1, depth)
    }

    findMinDistance()
    println(result)
}
