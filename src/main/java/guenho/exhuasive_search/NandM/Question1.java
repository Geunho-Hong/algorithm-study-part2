package guenho.exhuasive_search.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://st-lab.tistory.com/114
// https://www.acmicpc.net/problem/15649
// 중복없이 N개를 고르는 경우의 수, BackTracking


public class Question1 {

    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static void sysout() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr : " + arr[i] + " ");
        }
        for (int i = 0; i < visited.length; i++) {
            System.out.println("visited : " + i + visited[i] + " ");
        }
    }

    private static void dfs(int N, int M, int depth) {
        if (depth == M) {
            // base case
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        System.out.println("new");

        for (int i = 0; i < N; i++) {
            System.out.println("not in : " + i);
            if (!visited[i]) {
                System.out.println("i= " + i);
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                System.out.println("i after = " + i);
                System.out.println("test");
                //sysout();
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

        dfs(N, M, 0);
    }
}
