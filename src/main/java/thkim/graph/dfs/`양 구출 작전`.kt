package thkim.graph.dfs

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val numOfObjects = IntArray(N + 1)
    val nodeLists = MutableList<MutableList<Int>>(N + 1) { mutableListOf() }

    for (i in 2..N) {
        val data = readLine().split(" ")
        numOfObjects[i] = if (data[0] == "S") data[1].toInt() else -data[1].toInt()
        nodeLists[data[2].toInt()].add(i)
    }

    fun findSheep(node: Int): Long {
        var sum = 0L

        for (next in nodeLists[node]) {
            sum += findSheep(next)
        }

        return if (sum + numOfObjects[node] >= 0) sum + numOfObjects[node] else 0
    }

    println(findSheep(1))
}
