package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Coin2 {

    /**
     * n가지 종류의 동전이 주어질 때, 합이 k원이 되는 구성의 동전 최소 개수는?
     * dp[i] = i원을 만드는 (중복되지 않은) 구성의 동전 최소 개수
     * dp[i] = min(1번째만으로 구성할 수 있는 동전 최소 개수, 2번째 추가해서 구성할 수 있는 경우의 수, ...k번째 추가해서 구성할 수 있는 경우의 수)
     * dp[i] = min(dp[i], dp[i-j] + 1)
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int k = parseInt(st.nextToken());
            int[] dp = new int[k + 1];
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = parseInt(br.readLine());
            }

            Arrays.fill(dp, 10001);
            dp[0] = 0;

            for (int coin : coins) {
                for (int j = coin; j <= k; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }

            System.out.println(dp[k] == 10001 ? -1 : dp[k]);
        }
    }
}
