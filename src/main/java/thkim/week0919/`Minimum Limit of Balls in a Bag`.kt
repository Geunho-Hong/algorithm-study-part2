package thkim.week0919

fun main() {
    `Minimum Limit of Balls in a Bag`().minimumSize(
        intArrayOf(2, 4, 8, 2),
        4
    )

    `Minimum Limit of Balls in a Bag`().minimumSize(
        intArrayOf(9),
        2
    )

    `Minimum Limit of Balls in a Bag`().minimumSize(
        intArrayOf(7, 17),
        2
    )
}

class `Minimum Limit of Balls in a Bag` {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var left = 1
        var right = 1_000_000_000

        fun computeCount(nums: IntArray, mid: Int): Int {
            var count = 0
            for (a in nums) {
                count += (a - 1) / mid
            }

            return count
        }

        while (left < right) {
            val mid = left + (right - left) / 2

            if (computeCount(nums, mid) > maxOperations) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }
}