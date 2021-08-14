package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val X = readLine().toInt()
    var total = 64
    val distanceStack = ArrayDeque<Int>()

    fun recursion() {
        if (total == X) return

        val currentDistance = distanceStack.removeFirst()
        val half = currentDistance / 2

        if (total > X) {
            distanceStack.addFirst(half)
            total -= half

            if (total < X) {
                distanceStack.addFirst(half)
                total += half
            }

            if (total == X) return
        }

        recursion()
    }

    distanceStack.addFirst(64)
    recursion()
    println(distanceStack.size)
}