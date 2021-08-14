package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    fun isRightString(s: String): Boolean {
        val len = s.length / 2

        for (i in 1..len) {
            if (s.substring(s.length - i) == s.substring(s.length - 2 * i, s.length - i)) {
                return false
            }
        }

        return true
    }

    fun findMinPermutation(result: String = "") {
        if (result.length == N) {
            println(result)
            exitProcess(0)
        }

        for (i in 1..3) {
            if (isRightString(result + i)) {
                findMinPermutation(result + i)
            }
        }
    }

    findMinPermutation()
}