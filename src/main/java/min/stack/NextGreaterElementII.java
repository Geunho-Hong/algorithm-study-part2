package min.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] result = nextGreaterElements(new int[]{1, 4, 3, 2, 5, 1});
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n * 2; i++) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                res[st.pop()] = nums[i % n];
            }

            if (i < n) {
                st.push(i);
            }
        }

        return res;
    }
}
