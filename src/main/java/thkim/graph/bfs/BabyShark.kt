package thkim.graph.bfs

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val matrix = Array(N) { IntArray(N) }

    var shark = -1 to -1
    var sharkSize = 2
    var feedCount = 0
    var distance = 0

    data class Point(val n: Int, val m: Int, val count: Int)

    for (i in 0 until N) {
        val data = readLine()
            .replace(" ", "")
            .map { Character.getNumericValue(it) }
            .toIntArray()
        for (j in 0 until N) {
            if (data[j] == 9) shark = i to j
            matrix[i][j] = data[j]
        }
    }

    val dn = intArrayOf(-1, 0, 0, 1)
    val dm = intArrayOf(0, -1, 1, 0)

    fun findFish(n: Int, m: Int): Boolean {
        val visited = Array(N) { BooleanArray(N) { false } }
        val queue = ArrayDeque<Point>()

        queue.addFirst(Point(n, m, 0))
        visited[n][m] = true

        while (queue.isNotEmpty()) {
            val p = queue.removeLast()

            val cn = p.n
            val cm = p.m
            val count = p.count

            loop@ for (i in 0 until 4) {
                val nextN = cn + dn[i]
                val nextM = cm + dm[i]

                if (nextN !in 0 until N || nextM !in 0 until N) continue@loop

                if (visited[nextN][nextM]) continue@loop

                if (sharkSize < matrix[nextN][nextM]) continue@loop

                if (sharkSize == matrix[nextN][nextM] || matrix[nextN][nextM] == 0) {
                    queue.addFirst(Point(nextN, nextM, count + 1))
                    visited[nextN][nextM] = true
                    continue@loop
                }

                if (sharkSize > matrix[nextN][nextM]) {
                    shark = nextN to nextM
                    distance += (count + 1)
                    feedCount++
                    if (feedCount == sharkSize) {
                        sharkSize++
                        feedCount = 0
                    }
                    matrix[nextN][nextM] = 0
                    queue.clear()
                    return true
                }
            }
        }

        return false
    }

    while (true) {
        if (findFish(shark.first, shark.second).not()) break
    }

    println(distance)
}