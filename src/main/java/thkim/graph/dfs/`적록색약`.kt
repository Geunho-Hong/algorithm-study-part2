package thkim.graph.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val rgb = Array(N) { CharArray(N) }
    val rrb = Array(N) { CharArray(N) }

    for (i in 0 until N) {
        val data = readLine().toCharArray()
        rgb[i] = data

        val arr = arrayListOf<Char>()

        for (j in 0 until N) {
            arr.add(if (data[j] == 'G') 'R' else data[j])
        }
        rrb[i] = arr.toCharArray()
    }

    val candidatesQ = ArrayDeque<Pair<Int, Int>>()
    var visited = Array(N) { BooleanArray(N) { false } }

    val dn = intArrayOf(0, 0, -1, 1)
    val dm = intArrayOf(1, -1, 0, 0)

    fun dfs(n: Int, m: Int, map: Array<CharArray>): Boolean {
        if (visited[n][m]) return false

        val color = map[n][m]
        visited[n][m] = true

        loop@ for (i in 0 until 4) {
            val nextN = n + dn[i]
            val nextM = m + dm[i]

            if (nextN !in 0 until N || nextM !in 0 until N) continue@loop

            if (visited[nextN][nextM]) continue@loop

            if (color == map[nextN][nextM]) dfs(nextN, nextM, map)
            else candidatesQ.addFirst(nextN to nextM)
        }

        return true
    }

    candidatesQ.addFirst(0 to 0)
    var rgbAreaCount = 0

    while (candidatesQ.isNotEmpty()) {
        val data = candidatesQ.removeLast()
        if (dfs(data.first, data.second, rgb)) rgbAreaCount++
    }

    candidatesQ.addFirst(0 to 0)
    var rrbAreaCount = 0
    visited = Array(N) { BooleanArray(N) { false } }

    while (candidatesQ.isNotEmpty()) {
        val data = candidatesQ.removeLast()
        if (dfs(data.first, data.second, rrb)) rrbAreaCount++
    }

    print("$rgbAreaCount $rrbAreaCount")
}
