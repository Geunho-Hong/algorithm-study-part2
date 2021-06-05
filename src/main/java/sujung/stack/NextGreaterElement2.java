package sujung.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length * 2; i++) {
            int index = i >= nums.length ? i % nums.length : i;

            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }

            if (i < nums.length) {
                stack.push(index);
            }
        }

        return result;
    }
}
