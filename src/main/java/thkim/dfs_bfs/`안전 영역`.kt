package thkim.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = Array(N) { IntArray(N) }
    val queue = PriorityQueue<Int>()

    var result = 0

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    queue.add(0)

    for (i in 0 until N) {
        val data = readLine()
            .trim()
            .replace(" ", "")
            .map { Character.getNumericValue(it) }
            .toIntArray()
        for (j in 0 until N) {
            arr[i][j] = data[j]

            if (queue.contains(arr[i][j]).not()) {
                queue.offer(arr[i][j])
            }
        }
    }

    fun dfs(h: Int, x: Int, y: Int, visited: Array<BooleanArray>) {
        visited[x][y] = true

        loop@ for (i in 0 until 4) { //
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue@loop
            if (arr[nextX][nextY] <= h) continue@loop
            if (visited[nextX][nextY]) continue@loop
            dfs(h, nextX, nextY, visited)
        }
    }

    while (queue.isNotEmpty()) {
        val height = queue.poll()

        val visited = Array(N) { BooleanArray(N) { false } }
        var count = 0

        for (i in 0 until N) {
            for (j in 0 until N) {
                if (visited[i][j].not() && arr[i][j] > height) {
                    dfs(height, i, j, visited)
                    count += 1
                }
            }
        }

        result = max(result, count)
    }

    println(result)
}
