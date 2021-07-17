package thkim.graph.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/2638
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val matrix = Array(N) { IntArray(M) } // 0 : Air, 1 : cheese

    val cheeseList = arrayListOf<Pair<Int, Int>>()

    for (i in 0 until N) {
        val data = readLine()
            .replace(" ", "")
            .map { Character.getNumericValue(it) }
            .toIntArray()
        for (j in 0 until M) {
            if (data[j] == 1) cheeseList.add(i to j)
            matrix[i][j] = data[j]
        }
    }

    var cheeseCount = cheeseList.size

    // right, left, up, down
    val dn = intArrayOf(0, 0, -1, 1)
    val dm = intArrayOf(1, -1, 0, 0)

    fun checkExternalAir(n: Int, m: Int, visited: Array<BooleanArray>) {
        visited[n][m] = true
        matrix[n][m] = 2 // 2 : external air.

        loop@ for (i in 0 until 4) {
            val nextN = n + dn[i]
            val nextM = m + dm[i]

            if (nextN !in 0 until N || nextM !in 0 until M) continue@loop

            if (matrix[nextN][nextM] == 1 || visited[nextN][nextM]) continue@loop

            checkExternalAir(nextN, nextM, visited)
        }
    }

    fun meltingCheese(i: Int) {
        if (i >= cheeseList.size) return

        val point = cheeseList[i]
        val n = point.first
        val m = point.second
        var count = 0

        for (j in 0 until 4) {
            val nextN = n + dn[j]
            val nextM = m + dm[j]

            if (matrix[nextN][nextM] == 2) count++
        }

        if (count >= 2) {
            matrix[n][m] = 0
            cheeseCount--
            cheeseList.removeAt(i)
            meltingCheese(i)
            return
        }

        meltingCheese(i + 1)
        return
    }

    var time = 0

    while (cheeseCount != 0) {
        time++
        checkExternalAir(0, 0, Array(N) { BooleanArray(M) { false } })
        meltingCheese(0)
    }

    println(time)
}
