package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (ROW, LadderCount, H) = readLine().split(' ').map { it.toInt() }
    val map = Array(H + 1) { IntArray(ROW + 1) }

    var finish = false
    var answer = 0

    fun isSameIndex(): Boolean {
        for (i in 1..ROW) {
            var height = 1
            var row = i

            for (j in 0 until H) {
                if (map[height][row] == 1) row++
                else if (map[height][row] == 2) row--
                height++
            }
            if (row != i) return false
        }
        return true
    }

    fun dfs(height: Int = 1, depth: Int = 0) {
        if (finish) return

        if (answer == depth) {
            if (isSameIndex()) finish = true
            return
        }

        for (i in height until H + 1) {
            for (j in 1 until ROW) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1
                    map[i][j + 1] = 2

                    dfs(i, depth + 1)

                    map[i][j + 1] = 0
                    map[i][j] = 0
                }
            }
        }
    }

    for (i in 0 until LadderCount) {
        val data = readLine().split(' ').map { it.toInt() }

        val height = data[0]
        val row = data[1]

        map[height][row] = 1
        map[height][row + 1] = 2
    }

    for (i in 0..3) {
        answer = i
        dfs()
        if (finish) break
    }

    println(if (finish) answer else -1)
}
