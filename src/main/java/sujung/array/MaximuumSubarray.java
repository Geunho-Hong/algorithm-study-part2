package sujung.array;

public class MaximuumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }

            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
