package thkim.week1003

fun main() {
    `Sort Colors`().sortColors(
        intArrayOf(2, 0, 2, 1, 1, 0)
    )

    `Sort Colors`().sortColors(
        intArrayOf(2, 0, 1)
    )
}

class `Sort Colors` {
    fun sortColors(nums: IntArray): Unit {
        var pivot = 0 // 변경 대상
        var p1 = 0 // 값 0의 가장 앞의 인덱스
        var p2 = nums.size - 1 // 값 2의 앞의 인덱스

        while (pivot <= p2) {
            when (nums[pivot]) {
                0 -> {
                    if (swap(nums, pivot, p1)) p1 += 1
                    else pivot += 1
                }

                2 -> {
                    swap(nums, pivot, p2)
                    p2 -= 1
                }

                else -> pivot += 1
            }
        }
    }

    private fun swap(nums: IntArray, idx1: Int, idx2: Int): Boolean {
        if (idx1 == idx2) return false

        val temp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = temp

        return true
    }
}