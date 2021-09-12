package min.dp.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {

    static int n;

    static long[] dp = new long[91]; // 1 < n < 90

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
        }

        // 1 -> 1 -> 1
        // 2 -> 10 -> 1
        // 3 -> 100, 101 -> 2
        // 4 -> 1000, 1001, 1010 -> 3
        // 5 -> 10000, 10001, 10010, 10100, 10101 -> 5

        // dp[5] = dp[5 - 1] + dp[5 - 2]
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
//            System.out.printf("dp[%d] = %d, dp[%d-2] = %d, dp[%d-1] = %d\n", i, dp[i], i, dp[i - 2], i, dp[i - 1]);
        }
        System.out.println(dp[n]);
    }

}