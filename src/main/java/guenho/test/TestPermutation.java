package guenho.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPermutation {

    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        arr = new int[M + 1];
        visited = new boolean[N + 1];

        dfs(1, 0);
    }

    private static void dfs(int start, int depth) {

        // base case
        if (depth == M) {
            for (int i = 0; i < arr.length -1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // for-loop
        // 나올수 있는 경우의 수를 우선 다구함;
        for (int i = start; i <= N; i++) {
            /*if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(i, depth + 1);
                visited[i] = false;
            }*/
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
