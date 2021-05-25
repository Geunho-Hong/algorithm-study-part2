package thkim.array

// https://leetcode.com/problems/container-with-most-water/
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        if (height.isEmpty()) return 0

        val size = height.size
        var leftPointer = 0
        var rightPointer = size - 1
        var maxArea = 0

        while (leftPointer < rightPointer) {
            val area = minOf(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer)
            maxArea = maxOf(maxArea, area)

            if (height[leftPointer] < height[rightPointer]) ++leftPointer
            else --rightPointer
        }

        return maxArea
    }
}