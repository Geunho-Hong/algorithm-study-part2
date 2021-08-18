package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

const val PLUS = 0
const val MINUS = 1
const val MUL = 2
const val DIV = 3

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val array = readLine().split(' ').map { it.toInt() }.toIntArray()
    val operators = readLine().split(' ').map { it.toInt() }.toIntArray()

    var maxValue = Int.MIN_VALUE // 최댓값
    var minValue = Int.MAX_VALUE // 최솟값

    fun dfs(num: Int = array[0], idx: Int = 1) {
        if (idx == N) {
            maxValue = max(maxValue, num)
            minValue = min(minValue, num)
            return
        }

        for (i in 0 until 4) {
            if (operators[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                operators[i]--
                when (i) {
                    PLUS -> dfs(num + array[idx], idx + 1)
                    MINUS -> dfs(num - array[idx], idx + 1)
                    MUL -> dfs(num * array[idx], idx + 1)
                    DIV -> dfs(num / array[idx], idx + 1)
                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operators[i]++
            }
        }
    }

    dfs()
    println(maxValue)
    println(minValue)
}