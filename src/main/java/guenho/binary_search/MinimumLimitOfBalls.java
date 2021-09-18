package guenho.binary_search;

// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
// https://leetcode.ca/2021-04-12-1760-Minimum-Limit-of-Balls-in-a-Bag/

import java.util.Arrays;

public class MinimumLimitOfBalls {
    public static void main(String[] args) {
        int[] nums = {2,4,8,2};
        System.out.println(minimumSize(nums, 4));
    }

    private static int minimumSize(int[] nums, int maxOperations) {

        Arrays.sort(nums);
        int length = nums.length;
        int low = 1, high = nums[length - 1];
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (isPossible(nums, maxOperations, mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static boolean isPossible(int[] nums, int maxOperations, int penalty) {
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num <= penalty)
                break;
            int operations = nums[i] / penalty -1;
            System.out.println("num = " + num);
            System.out.println("penalty = " + penalty);
            System.out.println("operation = " + operations);
            if (nums[i] % penalty != 0){
                System.out.println("num[i]%penalty = " + nums[i] % penalty);
                operations++;
            }
            count += operations;
            System.out.println("count = " + count);
        }
        return count <= maxOperations;
    }
}
