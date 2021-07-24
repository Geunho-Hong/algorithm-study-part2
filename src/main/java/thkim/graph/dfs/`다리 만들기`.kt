package thkim.graph.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

// todo : fix
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val map = Array(N) { IntArray(N) }.map {
        readLine()
            .replace(" ", "")
            .map { Character.getNumericValue(it) }
            .toIntArray()
    }

    val dn = intArrayOf(0, 0, -1, 1)
    val dm = intArrayOf(1, -1, 0, 0)

    data class Point(val n: Int, val m: Int)

    val candidateArray = arrayListOf<ArrayList<Point>>()
    val visited = Array(N) { BooleanArray(N) { false } }

    fun findCandidates(num: Int, n: Int, m: Int) {
        visited[n][m] = true

        loop@ for (i in 0 until 4) {
            val nextN = n + dn[i]
            val nextM = m + dm[i]

            if (nextN !in 0 until N || nextM !in 0 until N) continue@loop

            if (visited[nextN][nextM]) continue@loop

            if (map[nextN][nextM] == 0 && map[n][m] == 1) {
                if (candidateArray.size <= num) {
                    candidateArray.add(arrayListOf())
                }

                candidateArray[num].add(Point(n, m))
            }

            if (map[nextN][nextM] == 0) {
                visited[nextN][nextM] = true
                continue@loop
            }

            findCandidates(num, nextN, nextM)
        }
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (!visited[i][j] || map[i][j] != 0) findCandidates(candidateArray.size, i, j)
        }
    }

    var minDistance = 0

    fun searchDistance(idx1: Int, idx2: Int) {
        candidateArray[idx1].forEach { point1 ->
            candidateArray[idx2].forEach { point2 ->
                minDistance = min(abs(point1.n - point2.n) + abs(point1.m - point2.m) - 1, minDistance)
            }
        }
    }

    for (i in 0 until candidateArray.size) {
        for (j in i + 1 until candidateArray.size) {
            searchDistance(i, j)
        }
    }

    println(minDistance)
}