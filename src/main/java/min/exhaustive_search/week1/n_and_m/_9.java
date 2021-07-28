package min.exhaustive_search.week1.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9 {
    static int n;
    static int m;

    static int[] arr;
    static boolean[] visit;
    static int[] values;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        int preValue = -1; // 이전 값

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;

            int curValue = values[i];
            if (preValue == curValue) continue;

            visit[i] = true;
            arr[depth] = curValue;
            preValue = curValue;
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputArr = br.readLine().split(" ");
            n = Integer.parseInt(inputArr[0]);
            m = Integer.parseInt(inputArr[1]);

            arr = new int[m];
            visit = new boolean[n];
            values = new int[n];

            inputArr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(inputArr[i]);
            }
            Arrays.sort(values);
        }
    }
}
