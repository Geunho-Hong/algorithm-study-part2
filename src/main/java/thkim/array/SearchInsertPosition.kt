package thkim.array

import kotlin.math.abs

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        // 정렬되어있는 집합 -> 이진 검색 사용 가능.
        var i = nums.binarySearch(target)

        if (i < 0) i = abs(i + 1)

        return i
    }

    fun searchInsert2(nums: IntArray, target: Int): Int {
        for ((index, value) in nums.withIndex()) {
            if (value >= target) return index
        }
        return nums.size
    }

    fun searchInsert3(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size

        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            }
            if (nums[mid] > target) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}