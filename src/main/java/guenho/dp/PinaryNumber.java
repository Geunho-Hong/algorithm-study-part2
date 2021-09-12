package guenho.dp;

import java.util.Scanner;

// https://smartpro.tistory.com/50

public class PinaryNumber {

    private static long[][] dp;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new long[N + 1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        /**
         * 0으로 시작하는 경우 : 00,01
         * 1로 시작하는 경우 : 10
         */

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1]; // 0으로 시작
            dp[i][1] = dp[i-1][0];  // 1로 시작
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
