package guenho.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=occidere&logNo=220794872664

public class Coin2 {

    private static int N, K;
    private static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            K = Integer.parseInt(commands[1]);

            coins = new int[N];
            dp = new int[K + 1];

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            // dp 배열 : 최대금액 + 1
            Arrays.fill(dp, 100001);

            // 하나도 사용하지 않을 경우
            dp[0] = 0;

            for (int i = 0; i < N; i++) {
                for (int j = coins[i]; j <= K; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }

            dp[K] = (dp[K] == 100001) ? -1 : dp[K];

            System.out.println(dp[K]);
        }
    }
}
