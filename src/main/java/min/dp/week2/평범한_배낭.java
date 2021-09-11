package min.dp.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 0/1 knapsack problem
// YouTube: https://www.youtube.com/watch?v=H4UPhyhDyJk&t=887s
// Blog: https://st-lab.tistory.com/141
public class 평범한_배낭 {

    static int n, k;
    static int[] w = new int[100];
    static int[] v = new int[100];

    static int[][] dp = new int[101][100001]; // n = 최대 100, k = 최대 100,000

    public static void main(String[] args) throws IOException {
        // N 개의 물건 (N: 1 ~ 100)
        // 가방의 최대 무게(K)

        // 물건 = 무게(W: 1 ~ 100,000), 가치(V: 0 ~ 1,000)
        // 결과 = 최대 가치(MAX V)
        init();
        System.out.println(recursion(0, 0));
    }

    static int recursion(int depth, int weight) {
        if (depth == n) return 0;
        // 현재 depth에 같은 무게에 대한 최적의 가치가 있다면 바로 가치 반환
        if (dp[depth][weight] != 0) return dp[depth][weight];

        int include = 0;
        if (w[depth] + weight <= k) // 포함인 경우는 배낭의 무게가 넘지 않을 경우만 재귀 호출
            include = v[depth] + recursion(depth + 1, w[depth] + weight); // 포함
        int notInclude = recursion(depth + 1, weight); // 미포함

        return dp[depth][weight] = Math.max(include, notInclude);
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            k = Integer.parseInt(inputs[1]);

            for (int i = 0; i < n; i++) {
                inputs = br.readLine().split(" ");
                w[i] = Integer.parseInt(inputs[0]);
                v[i] = Integer.parseInt(inputs[1]);
            }
        }
    }

}