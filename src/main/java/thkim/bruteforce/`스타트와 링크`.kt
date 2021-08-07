package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val abilityArr = Array(N) { IntArray(N) }.map {
        readLine().split(' ').map { it.toInt() }.toIntArray()
    }

    val visited = BooleanArray(N) { false }

    var minValue = Int.MAX_VALUE

    fun findMinimum(pivot: Int = 0, depth: Int = 0) {
        if (depth == N / 2) {
            var teamStart = 0
            var teamLink = 0

            for (col in 0 until N - 1) {
                for (row in col + 1 until N) {
                    if (visited[col] && visited[row]) {
                        teamStart += abilityArr[col][row] + abilityArr[row][col]
                    } else if (visited[col].not() && visited[row].not()) {
                        teamLink += abilityArr[col][row] + abilityArr[row][col]
                    }
                }
            }
            minValue = min(minValue, abs(teamStart - teamLink))
            return
        }

        for (i in pivot until N) {
            if (visited[i].not()) {
                visited[i] = true
                findMinimum(i + 1, depth + 1)
                visited[i] = false
            }
        }
    }

    findMinimum()

    println(minValue)
}