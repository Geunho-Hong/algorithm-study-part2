package thkim.array

fun main() {
    println("--------------------------")
    testContainerWithMostWater()

    testSearchInsertPosition()

    testMaximumSubarray()

    testCombinationSum()
}

fun testContainerWithMostWater() {
    val containerWithMostWater = ContainerWithMostWater()

    println("11. Container With Most Water")
    println(containerWithMostWater.maxArea(intArrayOf(4, 3, 2, 1, 4)))
    println("--------------------------")
}

fun testSearchInsertPosition() {
    val searchInsertPosition = SearchInsertPosition()

    println("35. Search Insert Position")
    println(searchInsertPosition.searchInsert3(intArrayOf(1, 3, 5, 6, 8, 9, 11, 17, 20), 15))
    println("--------------------------")
}

fun testMaximumSubarray() {
    val maximumSubarray = MaximumSubarray()

    println("53. Maximum Subarray")
    println(maximumSubarray.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println("--------------------------")
}

fun testCombinationSum() {
    val combinationSum = CombinationSum()

    println("39. Combination Sum")
    println(combinationSum.combinationSum(intArrayOf(2, 3, 6, 7), 7))
    println("--------------------------")
}