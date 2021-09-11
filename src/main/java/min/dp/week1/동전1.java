package min.dp.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전1 {

    static int n, k;

    static int[] coin = new int[100];
    static int[] dp = new int[10001];

    // https://www.youtube.com/watch?v=2IkdAk1Loek
    public static void main(String[] args) throws IOException {
        input();

        /*
         *    1  2  3  4  5  6  7  8  9  10
         * 1  1  1  1  1  1  1  1  1  1   1
         * 2  0  1  1  2  2  3  3  4  4   5
         * 5  0  0  0  0  1  1  2  2  3   4
         * dp 1  2  2  3  4  4  5  7  8  10
         *
         *
         * dp[k] += dp[k - coin[i]]; -> 이전 동전 가치의 경우의 수에서 현재 동전 가치의 경우의수를 합산해줘야함 그래서 += (ex. k = 10, 1+5+4)
         */


        dp[0] = 1; // 같은 숫자에 대해서 뺄셈했을 때 무조건 경우의 수가 1이어야함
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            k = Integer.parseInt(inputs[1]);

            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }
        }
    }

}
