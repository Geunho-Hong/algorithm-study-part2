package thkim.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

class Solution(
    private val N: Int,
    private val M: Int,
    private val map: List<IntArray>
) {
    var result = Int.MIN_VALUE
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)

    fun buildWall(wallCount: Int) {
        if (wallCount == 3) {
            spread()
            return
        }

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] == 0) {
                    map[i][j] = 1
                    buildWall(wallCount + 1)
                    map[i][j] = 0
                }
            }
        }
    }

    private fun spread() {
        val spreadMap = Array(N) { IntArray(M) }
        // copy
        map.forEachIndexed { index, ints -> spreadMap[index] = ints }

        val queue = ArrayDeque<Pair<Int, Int>>()

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (spreadMap[i][j] == 2) queue.addFirst(i to j)
            }
        }

        while (queue.isNotEmpty()) {
            val pos = queue.removeLast()

            for (i in 0 until 4) {
                val nextX = pos.first + dx[i]
                val nextY = pos.second + dy[i]

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (spreadMap[nextX][nextY] == 0) {
                        spreadMap[nextX][nextY] = 2
                        queue.addFirst(nextX to nextY)
                    }
                }
            }
        }

        countSafeArea(spreadMap)
    }

    private fun countSafeArea(area: Array<IntArray>) {
        var count = 0

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (area[i][j] == 0) count++
            }
        }

        result = max(count, result)
    }

    fun printResult() = println(result)
}

// https://www.acmicpc.net/problem/14502
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val map = Array(N) { IntArray(M) }
        .map {
            readLine()
                .trim()
                .replace(" ", "")
                .map { Character.getNumericValue(it) }
                .toIntArray()
        }

    val solution = Solution(N, M, map)

    solution.buildWall(0)

    solution.printResult()
}
