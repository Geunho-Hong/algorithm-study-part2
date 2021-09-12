package guenho.dp;

// https://superbono-2020.tistory.com/173
// https://www.acmicpc.net/problem/11048

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Movement {

    private static int N, M;
    private static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            M = Integer.parseInt(commands[1]);

            map = new int[N + 1][M + 1];
            dp = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 1; j <= M; j++) {
                    map[i][j] = Integer.parseInt(line[j-1]);
                }
            }

            // dp는 현재식을 기준으로 전의 값 memorization 을 진행한다.
            // dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] )

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + map[i][j];
                }
            }

            System.out.println(dp[N][M]);
        }
    }
}
