package thkim.graph.bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (R, C) = readLine().split(' ').map { it.toInt() }
    val matrix = Array(R) { CharArray(C) }
        .map {
            readLine().map { it }
        }

    // right, left, up, down
    val dr = intArrayOf(0, 0, -1, 1)
    val dc = intArrayOf(1, -1, 0, 0)

    var maxCount = 0

    fun dfs(r: Int, c: Int, count: Int, visited: HashMap<Char, Int?>) {
        visited[matrix[r][c]] = 1

        loop@ for (i in 0 until 4) {
            val nr = r + dr[i]
            val nc = c + dc[i]

            if (nr !in 0 until R || nc !in 0 until C) continue@loop

            if (visited[matrix[nr][nc]] != null) {
                maxCount = max(maxCount, count)
                continue@loop
            }

            dfs(nr, nc, count + 1, visited)
            visited[matrix[nr][nc]] = null
        }

    }

    dfs(0, 0, 1, hashMapOf())

    println(maxCount)
}
