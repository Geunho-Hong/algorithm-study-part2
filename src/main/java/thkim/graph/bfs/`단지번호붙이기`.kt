package thkim.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val matrix = Array(N) { IntArray(N) }
        .map {
            readLine().map { Character.getNumericValue(it) }.toIntArray()
        }
    val visited = Array(N) { BooleanArray(N) { false } }
    val answer = arrayListOf<Int>()

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    fun dfs(x: Int, y: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()

        var count = 0

        visited[x][y] = true
        queue.add(x to y)

        while (queue.isNotEmpty()) {
            count++
            val data = queue.removeLast()

            loop@ for (i in 0 until 4) { // 0: Down, 1: Up, 2: Right, 3: Left
                val nextX = data.first + dx[i]
                val nextY = data.second + dy[i]

                if (nextX !in 0 until N || nextY !in 0 until N) continue@loop

                if (visited[nextX][nextY]) {
                    visited[nextX][nextY] = true
                    continue@loop
                }

                if (matrix[nextX][nextY] != 0) {
                    visited[nextX][nextY] = true
                    queue.add(nextX to nextY)
                }
            }
        }

        answer.add(count)
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (visited[i][j].not() && matrix[i][j] != 0) {
                dfs(i, j)
            }
        }
    }

    println(answer.size)
    answer.sorted().forEach { println(it) }
}