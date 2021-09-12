package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCS {

    private static String first, second;
    private static int[][] dp;

    /**
     * Longest Common Subsequence 최장 공통 부분 수열 (부분수열이란 연속적이지 않지만 순서대로 나열될 수 있는 문자열)
     * 두 수열이 주어질 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것(길이) 찾기
     * dp[i][j] = 첫번째 문자열 인덱스 i까지, 두번째 문자열 인덱스 j까지의 LCS
     * BottomUp의 경우, 인덱스 표현을 쉽게 하고자 실제 인덱스 + 1 처리를 함
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            first = br.readLine();
            second = br.readLine();
            dp = new int[first.length()][second.length()];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            int result = computeByTopDown(0, 0);

//            int result = computeByBottomUp(new int[first.length() + 1][second.length() + 1]);

            System.out.println(result);
        }
    }

    private static int computeByTopDown(int i, int j) {
        if (i >= first.length() || j >= second.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (first.charAt(i) == second.charAt(j)) {
            dp[i][j] = 1 + computeByTopDown(i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(computeByTopDown(i + 1, j), computeByTopDown(i, j + 1));
        }
        return dp[i][j];
    }

    private static int computeByBottomUp(int[][] dp) {
        for (int i = 0; i <= first.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= second.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;    // 이전 인덱스들에 대한 LCS + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);    // 각 현재 인덱스 제외 이전 인덱스에 대한 LCS 최대값
                }
            }
        }
        return dp[first.length()][second.length()];
    }
}
