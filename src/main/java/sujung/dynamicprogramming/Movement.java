package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Movement {

    /**
     * (1,1)에서 (N,M)으로 이동 시 가져올 수 있는 최대 사탕 개수는 ?
     * dp[i][j] = (i, j) 좌표까지 도달 시 획득하는 최대 사탕 개수 = Max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 현재 좌표의 사탕 개수
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());
            int[][] map = new int[N][M];
            int[][] dp = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = parseInt(st.nextToken());
                    if (i - 1 >= 0 && dp[i - 1][j] > dp[i][j]) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (j - 1 >= 0 && dp[i][j - 1] > dp[i][j]) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    if (i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] > dp[i][j]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    dp[i][j] += map[i][j];
                }
            }
            System.out.println(dp[N - 1][M - 1]);
        }
    }
}
