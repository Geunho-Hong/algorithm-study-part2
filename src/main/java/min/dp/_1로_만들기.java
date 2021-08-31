package min.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로_만들기 {

    public static void main(String[] args) throws IOException {
        int x;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            x = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[x]);
    }
}
