package min.exhaustive_search.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스타트와_링크 {

    static int n;
    static int[][] S;
    static boolean[] visit;

    static int minDeviation = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0);
        System.out.println(minDeviation);
    }

    static void dfs(int k, int depth) {
        if (depth == n / 2) { // star 와 link 2개의 팀으로 나눠야하기 때문에 절반만 true로 변경하면 됨
            calcDeviation();
            return;
        }

        // 계속 0부터 돌면 중복되는 경우가 발생하기 때문에 k를 기준으로 dfs 실행
        for (int i = k; i < n; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    static void calcDeviation() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) start += S[i][j] + S[j][i];
                else if (!visit[i] && !visit[j]) link += S[i][j] + S[j][i];
            }
        }

        int deviation = Math.abs(start - link);
        if (deviation == 0) { // 편차가 0이면 더이상 실행할 필요 없음
            System.out.println(0);
            System.exit(0);
        }
        minDeviation = Math.min(minDeviation, deviation);
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            S = new int[n][n];
            visit = new boolean[n];

            for (int i = 0; i < n; i++) {
                String[] arr = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    S[i][j] = Integer.parseInt(arr[j]);
                }
            }
        }
    }
}