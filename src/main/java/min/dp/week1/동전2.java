package min.dp.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전2 {

    static int n, k;

    static int[] coin = new int[100];
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        input();

        /*
         *          1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
         * [0] 1    1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
         * [1] 5    0  0  0  0  1  2  3  4  5   2   3   4   5   6   3
         * [2] 12   0  0  0  0  0  0  0  0  0   0   0   1   2   3   4
         *
         * dp[j] = Math.min(dp[j], dp[j - coin[i] + 1);
         */

        Arrays.fill(dp, 100001);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1); // 최소 경우의수 계속 갱신
            }
        }

        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            k = Integer.parseInt(inputs[1]);

            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }
        }
    }

}