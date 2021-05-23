package min.array;

/**
 * 최대 구간 합 문제
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int negativeResult = maxSubArrayKadanes(new int[]{-1});
        System.out.println("negativeResult = " + negativeResult);

        int result = maxSubArrayKadanes(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("result = " + result);
    }

    // https://sustainable-dev.tistory.com/23
    public static int maxSubArrayKadanes(int[] nums) { // DP O(n)
        // max 를 첫 번째 원소로 초기화
        int globalMax = nums[0]; // 결과
        int localMax = nums[0]; // 이전까지의 합을 저장해놔야 하기 때문에 for문 밖에 선언

        for (int i = 1; i < nums.length; i++) { // 첫번째 원소는 값 자체가 max 이기 때문에 두 번째 원소부터 계산
            localMax = Math.max(nums[i], localMax + nums[i]);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }

    public static int maxSubArrayBruteForce(int[] nums) { // Brute Force O(n2)
        int max = -1000001; // nums 원소의 최소값이 -100만이기 때문에 더 작은 값으로 초기화해줌

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

}