package guenho.exhuasive_search.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question5 {

    private static int N, M;
    private static int[] arr;
    private static int[] columnArr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int N, int M, int depth) {

        if (M == depth) {
            for (int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                //arr[depth] = i + 1;
                arr[depth] = columnArr[i];
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        arr = new int[M];
        visited = new boolean[N];
        columnArr = new int[N];

        String[] columns = br.readLine().split(" ");

        for (int i = 0; i < columns.length; i++) {
            columnArr[i] = Integer.parseInt(columns[i]);
        }
        Arrays.sort(columnArr);

        dfs(N, M, 0);
        System.out.print(sb.toString());
    }
}
