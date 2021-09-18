package guenho.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/141

public class NormalBackpack {

    private static int N, K;
    private static int[] weight, value;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            K = Integer.parseInt(commands[1]);

            weight = new int[N];
            value = new int[N];

            for (int i = 0; i < N; i++) {
                String[] back = br.readLine().split(" ");
                weight[i] = Integer.parseInt(back[0]);
                value[i] = Integer.parseInt(back[1]);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    if(weight[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                    }
                }
            }
            System.out.println(dp[N][K]);
        }
    }
}
