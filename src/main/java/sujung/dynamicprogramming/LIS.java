package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class LIS {

    private static int N;
    private static int[] nums, dp;

    /**
     * Longest Increasing Subsequence 가장 긴 증가하는 부분 수열 (길이)
     * dp[i] = 인덱스 i까지의 LIS = Max(dp[0]...dp[i-1]) + 1
     * N^2의 시간복잡도
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = parseInt(st.nextToken());
            }
            dp = new int[N];

            computeByBottomUp();
            /**
             for (int i = 0; i < N; i++) {
             dp[i] = computeByTopDown(i);
             }
             **/
            Arrays.sort(dp);
            int result = dp[N - 1];
            System.out.println(result);
        }
    }

    private static void computeByBottomUp() {
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }
            dp[i] = temp;
        }
    }

    private static int computeByTopDown(int i) {
        if (i == 0) return 1;
        if (dp[i] != 0) return dp[i];

        int temp = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                temp = Math.max(temp, computeByTopDown(j) + 1);
            }
        }
        dp[i] = temp;
        return dp[i];
    }
}
