package thkim.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/2178
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val matrix = Array(N) { IntArray(M) }
        .map {
            readLine().map { Character.getNumericValue(it) }.toIntArray()
        }

    val visited = Array(N) { IntArray(M) { 1 } }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    fun dfs(x: Int, y: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()

        queue.add(x to y)

        while (queue.isNotEmpty()) {
            val data = queue.removeLast()

            loop@ for (i in 0 until 4) { // 0: Down, 1: Up, 2: Right, 3: Left
                val curCount = visited[data.first][data.second]

                val nextX = data.first + dx[i]
                val nextY = data.second + dy[i]

                if (nextX !in 0 until N || nextY !in 0 until M) continue@loop

                if (visited[nextX][nextY] <= curCount) {
                    continue@loop
                }

                if (matrix[nextX][nextY] != 0) {
                    visited[nextX][nextY] = curCount + 1
                    queue.add(nextX to nextY)
                }
            }
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            dfs(i, j)
        }
    }

    println(visited[N][M])
}
