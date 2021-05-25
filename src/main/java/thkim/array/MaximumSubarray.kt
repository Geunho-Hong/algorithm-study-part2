package thkim.array

class MaximumSubarray {

    // DP(Dynamic Programming) 동적 계획법
    // 동적 계획법은 문제를 풀 때 하나의 문제를 여러 하위 문제로 나누어 풀고,
    // 그것들을 결합해서 최종 목적에 도달하는 방식의 알고리즘
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var current = 0

        nums.forEach {
            current = maxOf(current + it, it)
            max = maxOf(max, current)
        }

        return max
    }

}