package guenho.month_october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=occidere&logNo=221056531437

/**
 * dfs로 가지치기 방식이 아니라 dp를 활용하는 문제
 * 다음 상태를 구하기 위해 이전 상태를 저장하고 활용한다
 */

/**
 * Top-down : 가장 큰 문제를 방문 후 작은 문제를 호출하여 값을 찾음 (재귀 호출)
 * Bottom-up : 가장 작은 문제들 부터 답을 구해가며 전체 문제의 답을 찾음 (반복문)
 */

/**
 * 처음에는 효율성을 위해 반복문을 사용하는 Bottom-up 방식으로 접근한 후,
 * 하위 문제가 복잡하여 점화식을 세우기 힘든 경우 Top-down 으로 접근하는것이 권장된다.
 */

public class OneGrade {

    private static int N;
    private static int[] arr;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            // Number range is 0 to 20
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            String[] line = br.readLine().split(" ");

            for (int i = 0; i < line.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }

            dp = new long[N][21];
            dp[0][arr[0]] = 1;

            for (int i = 1; i <= N-1; i++) {
                for (int j = 0; j <= 20; j++) {
                    if(dp[i-1][j] != 0) {
                        // case 1 : 이전에 만들 수 있는 경우의 수와 더하는 경우의 수
                        if(j + arr[i] <= 20) dp[i][j+arr[i]] += dp[i-1][j];
                        // case 2 : 이전에 만들 수 있는 경우의 수와 빼는 경우의 수
                        if(j - arr[i] >= 0) dp[i][j-arr[i]] += dp[i-1][j];
                    }
                }
            }

            System.out.println(dp[N-2][arr[N-1]]);

        }
    }
}
