package guenho.sort;

import java.util.ArrayList;
import java.util.List;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        List<Integer> answerList = new ArrayList<>();

        /**
         * 0 : red
         * 1 : white
         * 2 : blue
         */

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    answerList.add(nums[j]);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = answerList.get(i);
        }


        // another solve
        // 0과 2를 이동하고 나면 1은 자연스레 자리에 남는다.
        int left = 0;
        int right = nums.length - 1;

        for (int i = left; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left++);
            } else if (nums[i] == 2) {
                swap(nums, i--, right--);
            }
        }

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
