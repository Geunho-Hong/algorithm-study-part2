package min.exhaustive_search.week1.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1 {

    static int n;
    static int m;

    static int[] arr;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i : arr)
                sb.append(i).append(" ");
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputArr = br.readLine().split(" ");
            n = Integer.parseInt(inputArr[0]);
            m = Integer.parseInt(inputArr[1]);

            arr = new int[m];
            visit = new boolean[n];
        }
    }

}
