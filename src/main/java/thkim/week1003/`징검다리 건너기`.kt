package thkim.week1003

fun main() {
    `징검다리 건너기`().solution(
        intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1),
        3
    )
}

class `징검다리 건너기` {
    fun solution(stones: IntArray, k: Int): Int {
        var left = 1
        var right = 200_000_001

        var copyStones: IntArray

        while (left < right) {
            copyStones = stones
            val mid = left + (right - left) / 2

            if (checkAcrossCount(copyStones, k, mid)) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left - 1
    }

    private fun checkAcrossCount(stones: IntArray, k: Int, friendCount: Int): Boolean {
        var invalidStoneCount = 0

        stones.forEach { stoneCount ->
            if (stoneCount - friendCount < 0) {
                invalidStoneCount += 1
            } else {
                invalidStoneCount = 0
            }

            if (invalidStoneCount >= k) return false
        }

        return true
    }
}