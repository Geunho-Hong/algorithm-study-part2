package sujung.binarysearch;

public class MinimumLimitOfBallsInABag {
    /**
     * 최대 maxOperations 횟수에 아래 연산을 수행한다.
     * 공 하나가 든 가방을 골라서 새로운 두 개의 가방에 양의 정수개의 공을 나눠 넣는다.
     * 가방 속에 가장 많은 개수의 공이 문제가 되므로, 연산 이후에 이를 최소화해야 한다.
     */

    /**
     * 최소 패널티(공 개수)를 이분탐색으로 찾기
     * @param nums
     * @param maxOperations
     * @return
     */
    public int minimumSize(int[] nums, int maxOperations) {

        int left = 1;
        int right = 1_000_000_000;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (computeCountOfOps(nums, mid) > maxOperations) { // 가능한 연산 횟수를 넘어서면 최소 패널티를 늘려본다.
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int computeCountOfOps(int[] nums, int mid) {
        int count = 0;
        for (int a : nums) {
            count += (a - 1) / mid;
        }
        return count;
    }
}
