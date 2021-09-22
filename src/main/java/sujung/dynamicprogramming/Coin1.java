package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Coin1 {

    /**
     * n가지 종류의 동전이 주어질 때, k원이 되는 동전 구성의 경우의 수는?
     * dp[i] = i원을 만드는 (중복되지 않는) 구성 경우의 수
     * dp[i] = 1번째만으로 구성할 수 있는 경우의 수 + 2번째 추가해서 구성할 수 있는 경우의 수 + ...k번째 추가해서 구성할 수 있는 경우의 수
     * dp[i] = dp[i] + dp[i-j] (j는 주어진 동전 종류) = j원을 미포함 + 포함
     * 코인의 개수를 늘려가므로 동전 구성 중복케이스를 제거할 수 있다.
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

            dp[0] = 1;
            for (int coin : coins) {
                for (int j = coin; j <= k; j++) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
            System.out.println(dp[k]);
        }
    }
}
