package thkim.week1003

fun main() {
    `Search Insert Position`().searchInsert(
        intArrayOf(1, 3, 5, 6),
        2
    )
}

class `Search Insert Position` {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size

        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] < target) left = mid + 1
            else right = mid
        }
        return left
    }

}