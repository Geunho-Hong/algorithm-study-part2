package guenho.exhuasive_search.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3 {

    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();


    private static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);
        System.out.print(sb.toString());
    }
}
