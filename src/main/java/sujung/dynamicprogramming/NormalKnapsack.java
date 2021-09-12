package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class NormalKnapsack {

    private static int N;   // 물건 수
    private static int K;   // 배낭 용량
    private static int[] weights, values;   // 물건별 무게 및 가치
    private static int[][] dp;

    /**
     * 0 / 1 냅색 문제, 배낭에 넣을 수 있는 물건들 가치의 최대값은 ?
     * dp[i][j] = i번째까지의 물건에 대해(포함/미포함 결정) 현재 남은 배낭 용량이 j일 때, 배낭에 들은 가치의 최대값
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());   // 물건 수
            K = parseInt(st.nextToken());   // 배낭 용량
            weights = new int[N];
            values = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                weights[i] = parseInt(st.nextToken());
                values[i] = parseInt(st.nextToken());
            }
            dp = new int[N][K + 1];

            int result = computeByBottomUp();

            /**
             for(int i=0; i<N; i++) {
             Arrays.fill(dp[i], -1);
             }
             int result = computeByTopDown(0, K);
             **/

            System.out.println(result);

        }
    }

    private static int computeByBottomUp() {
        for (int i = 0; i <= K; i++) {
            if (weights[0] <= i) {
                dp[0][i] = values[0];   // 첫번째 아이템 포함 가능 확인 처리
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                int selected = 0, notSelected = 0;
                if (weights[i] <= j) {  // 남은 용량보다 작으면 포함하고 가치 계산
                    selected = values[i] + dp[i - 1][j - weights[i]];
                }
                notSelected = dp[i - 1][j]; // 미포함 시 가치 계산

                dp[i][j] = Math.max(selected, notSelected);
            }
        }
        return dp[N - 1][K];
    }

    private static int computeByTopDown(int index, int capacity) {
        if (capacity <= 0 || index >= N) {
            return 0;
        }
        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        int selected = 0;
        if (weights[index] <= capacity) {
            selected = values[index] + computeByTopDown(index + 1, capacity - weights[index]);
        }
        int notSelected = computeByTopDown(index + 1, capacity);

        dp[index][capacity] = Math.max(selected, notSelected);
        return dp[index][capacity];
    }
}
