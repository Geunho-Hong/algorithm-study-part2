package guenho.dp;

// https://www.youtube.com/watch?v=2IkdAk1Loek

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin1 {

    private static int N,K;
    private static int[] coins,dp;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            K = Integer.parseInt(commands[1]);

            // 동전의 종류
            coins = new int[N];

            // 동전을 만들 수 있는 경우의 수
            dp = new int[K+1];

            // 나 자신의 경우의 수
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            /**
             *      1 2 3 4 5 6 7 8 9 10
             *  1   1 1 1 1 1 1 1 1 1 1
             *  2   0 1 1 2 2 3 3 4 4 5
             *  5   0 0 0 0 1 1 2 2 3 4
             *        2 2 3 4 5 5 7 8 10
             */

            /**
             * 4원을 구하려면 -> 2원의 경우의 수 + 현재 코인 값만 추가
             */

            for (int i = 0; i < N; i++) {
                for (int j = coins[i]; j <=K; j++) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                    System.out.println("dp[j] value= " + dp[j] + " j = " + j);
                }
            }

            System.out.println(dp[K]);

        }
    }
}
