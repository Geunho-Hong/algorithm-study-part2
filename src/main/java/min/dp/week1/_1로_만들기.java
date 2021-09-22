package min.dp.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로_만들기 {

    static int x;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            x = Integer.parseInt(br.readLine());
        }

        // dp[1 ~ x] = 1로 만드는 최소 연산 횟수
        dp = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            // 1을 뺀 값에 대한 최소 연산 횟수보다 1회 더 추가 연산한 값 저장
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0)
                // 현재 i의 최소 연산횟수와 i를 2로 나눈 값의 최소 연산 횟수 + 1 의 최소값 갱신
                // dp[4 / 2] = dp[2] + 1 (나누기 2 연산에 대한 추가 횟수)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            if (i % 3 == 0)
                // 현재 i의 최소 연산횟수와 i를 3으로 나눈 값의 최소 연산 횟수 + 1 의 최소값 갱신
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[x]);
    }
}
