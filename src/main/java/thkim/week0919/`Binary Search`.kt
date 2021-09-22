package thkim.week0919

class `Binary Search` {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val pivot = (left + right) / 2

            if (nums[pivot] == target) return pivot

            if (nums[pivot] > target) {
                right = pivot - 1
            } else {
                left = pivot + 1
            }
        }

        return -1
    }
}