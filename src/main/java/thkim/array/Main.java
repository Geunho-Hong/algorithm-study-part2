package thkim.array;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));

        int[] nums2 = {8, 20, 1, 2, 3, 4, 5, 6};
        System.out.println(solution.maxArea(nums2));

        int[] num3 = {2, 3, 5};
        System.out.println(solution.combinationSum(num3, 8));
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

        // https://leetcode.com/problems/container-with-most-water/
        public int maxArea(int[] height) {
            int leftIdx = 0;
            int maxArea = Math.min(height[0], height[1]);
            int finArea = maxArea;

            int maxHeightIdx = 0;
            for (int i = 2; i < height.length; i++) {
                for (int j = leftIdx; j < i; j++) {
                    if (height[j] > height[maxHeightIdx]) {
                        maxHeightIdx = j;

                        if (height[maxHeightIdx] * (i - maxHeightIdx) > maxArea) {
                            leftIdx = maxHeightIdx;
                        }
                    }

                    maxArea = Math.max(maxArea, (i - j) * Math.min(height[i], height[j]));

                    if (finArea < maxArea || maxArea == 0) {
                        finArea = maxArea;

                        int nextArea = Math.min(height[j], height[i]) * (i - (j));

                        if (maxArea < nextArea) {
                            maxArea = nextArea;
                            finArea = nextArea;
                        }
                    }
                }
            }

            return finArea;
        }

        // https://leetcode.com/problems/combination-sum/
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> answer = new ArrayList<>();

            for (int index = 0; index < candidates.length; index++) {
                for (int m = target / candidates[index]; m > 0; m--) {
                    int num = target - (candidates[index] * m);

                    for (int i = index; i < candidates.length; i++) {
                        List<Integer> list = new ArrayList<>();

                        if (num == 0) {
                            if (candidates[i] == candidates[index] && target == candidates[index]) {
                                list.add(candidates[index]);

                                answer.add(list);
                            }
                        } else if (candidates[i] == num || (candidates[i] % num == 0 && num != 1)) {
                            int count = num / candidates[i];

                            if (count == 0) continue;

                            for (int q = 0; q < m; q++) {
                                list.add(candidates[index]);
                            }

                            for (int q = 0; q < count; q++) {
                                list.add(candidates[i]);
                            }

                            answer.add(list);
                        }
                    }
                }
            }

            return answer;
        }

        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> answer = new ArrayList<>();

            for (int i = 0; i < candidates.length; i++) {

            }

            return answer;
        }

        public List<Integer> findNum(int[] candidates, int target, int idx) {

            for (int i = idx; i < candidates.length; i++) {
                int currentNum = candidates[i];

            }
        }
    }

}