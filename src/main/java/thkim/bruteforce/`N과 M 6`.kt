package thkim.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }

    val arr = arrayListOf<Int>()

    readLine().split(" ").forEach { arr.add(it.toInt()) }

    fun permutation(nums: List<Int>, index: Int = 0, depth: Int = nums.size, combination: IntArray) {
        if (index == nums.size) {
            if (depth == 0) {
                combination.forEach { print("$it ") }
                println()
            }
        } else {
            permutation(nums, index + 1, depth - 1, combination + nums[index])
            permutation(nums, index + 1, depth, combination)
        }
    }

    permutation(arr.sorted(), depth = M, combination = intArrayOf())
}