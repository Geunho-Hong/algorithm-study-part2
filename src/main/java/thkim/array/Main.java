package thkim.array;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }

    static class Solution {
        // https://leetcode.com/problems/search-insert-position/
        public int searchInsert(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) return i;
            }

            return nums.length;
        }

        // https://leetcode.com/problems/maximum-subarray/
        public int maxSubArray(int[] nums) {
            int tempMax = nums[0];
            int finalMax = tempMax;

            for (int i = 1; i < nums.length; i++) {
                tempMax = Math.max(nums[i], tempMax + nums[i]);

                if (tempMax > finalMax) {
                    finalMax = tempMax;
                }
            }

            return finalMax;
        }
    }

}