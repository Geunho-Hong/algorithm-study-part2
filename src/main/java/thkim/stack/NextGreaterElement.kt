package thkim.stack

import java.util.*

class NextGreaterElement {

    fun nextGreaterElements(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        val stack = Stack<Int>()

        // nums 를 우측에서 좌측으로 2회 순회
        for (i in 2 * nums.size - 1 downTo 0) {
            // nums 의 현재 포인터와 stack 의 index(현재 포인터의 우측)를 이용하여 큰 수가 있는지 비교
            while (stack.isNotEmpty() && nums[stack.peek()] <= nums[i % nums.size]) {
                stack.pop()
            }

            // stack 에 index 가 없다면 -1, 있다면 nums 의 index 를 참조한 값을 insert
            answer[i % nums.size] = if (stack.empty()) -1 else nums[stack.peek()]
            stack.push(i % nums.size) // 현재 인덱스를 stack 에 push
        }

        return nums
    }

}