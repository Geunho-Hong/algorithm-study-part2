package thkim.week1003

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (M, N) = readLine().split(' ').map(String::toInt)
    val tomatoBox = Array(N) { IntArray(M) }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(N) { BooleanArray(M) }
    var tomatoCount = 0

    for (i in 0 until N) {
        val data = readLine().split(' ').map(String::toInt)

        for (j in 0 until M) {
            tomatoBox[i][j] = data[j]

            if (data[j] == 1) {
                queue.addFirst(i to j)
                visited[i][j] = true
            } else if (data[j] == 0) {
                tomatoCount += 1
            }
        }
    }

    var spreadTomatoCount = 0

    fun spreadTomato() {
        val dm = intArrayOf(1, -1, 0, 0)
        val dn = intArrayOf(0, 0, -1, 1)

        val pos = queue.removeLast()

        for (i in 0 until 4) {
            val nextN = pos.first + dn[i]
            val nextM = pos.second + dm[i]

            if (nextN !in 0 until N || nextM !in 0 until M) continue
            if (visited[nextN][nextM]) continue

            if (tomatoBox[nextN][nextM] == 0) {
                visited[nextN][nextM] = true
                tomatoBox[nextN][nextM] = 1
                queue.addFirst(nextN to nextM)
                spreadTomatoCount += 1
            }
        }
    }

    if (tomatoCount == 0) {
        println(0)
        exitProcess(0)
    }

    var day = 0
    while (queue.isNotEmpty()) {
        for (i in queue.indices) spreadTomato()

        day += 1

        if (spreadTomatoCount == tomatoCount) {
            println(day)
            exitProcess(0)
        }
    }

    println(-1)
}