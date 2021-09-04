package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class PinaryNumber {

    /**
     * 이친수는 0으로 시작하지 않는다, 1이 두 번 연속으로 나타나지 않는다.
     * dp[i][j] = 끝자리가 j인 i자리의 이친수 개수 (0 <= j <= 1)
     * dp[i][0] = dp[i-1][1] + dp[i-1][0]
     * dp[i][1] = dp[i-1][0]
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int num = parseInt(br.readLine());
            if(num == 1) {
                System.out.println(1);
                return;
            }

            long[][] dp = new long[num + 1][2];
            dp[1][0] = 0;
            dp[1][1] = 1;
            dp[2][0] = 1;
            dp[2][1] = 0;
            for (int i = 3; i <= num; i++) {
                dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
                dp[i][1] = dp[i - 1][0];
            }
            System.out.println(dp[num][0] + dp[num][1]);
        }
    }
}
