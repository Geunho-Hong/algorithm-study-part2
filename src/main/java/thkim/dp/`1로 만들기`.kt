package thkim.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = IntArray(N + 1) { Int.MAX_VALUE }
    arr[0] = 0
    arr[1] = 0

    fun operator(target: Int): Int {
        if (arr[target] == Int.MAX_VALUE) {
            when {
                target % 6 == 0 -> {
                    arr[target] = min(
                        operator(target - 1),
                        min(operator(target / 3), operator(target / 2))
                    ) + 1
                }

                target % 3 == 0 -> {
                    arr[target] = min(
                        operator(target / 3),
                        operator(target - 1)
                    ) + 1
                }
                target % 2 == 0 -> {
                    arr[target] = min(
                        operator(target / 2),
                        operator(target - 1)
                    ) + 1
                }
                else -> {
                    arr[target] = operator(target - 1) + 1
                }
            }
        }

        return arr[target]
    }

    println(operator(N))
}
