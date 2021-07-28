package min.exhaustive_search.week1.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10 {

    static int n;
    static int m;

    static boolean[] visit;
    static int[] arr;
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

        int preValue = -1;

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;

            int curValue = values[i];
            if (depth > 0 && arr[depth - 1] > curValue || preValue == curValue) continue;

            visit[i] = true;
            arr[depth] = curValue;
            preValue = curValue;
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strings = br.readLine().split(" ");
            n = Integer.parseInt(strings[0]);
            m = Integer.parseInt(strings[1]);

            visit = new boolean[n];
            arr = new int[m];
            values = new int[n];

            strings = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(values);
        }
    }

}
