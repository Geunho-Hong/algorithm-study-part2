package guenho.exhuasive_search;

// https://www.acmicpc.net/problem/14889
// https://st-lab.tistory.com/122

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartAndLink {

    private static int N;
    private static int[][] map;
    private static boolean[] visited;
    private static int[] arr;
    private static int min = Integer.MAX_VALUE;

    private static void dfs(int idx, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false; // 재귀 종료시 비 방문 처리
            }
        }
    }

    private static void diff() {

        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i; j < N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    // 두 값이 방문했다면
                    startTeam += map[i][j];
                    startTeam += map[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }
            }
        }

        int result = Math.abs(startTeam - linkTeam);
        //System.out.println("result : " + result);

        if (result == 0) {
            System.out.println(result);
            System.exit(0);
        }

        min = Math.min(result, min);

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            arr = new int[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                String[] rows = br.readLine().split(" ");
                for (int j = 0; j < rows.length; j++) {
                    map[i][j] = Integer.parseInt(rows[j]);
                }
            }
            dfs(0, 0);
            System.out.println(min);
        }
    }

    private static void sysout() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
