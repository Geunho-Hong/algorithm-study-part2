package guenho.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartAndLink {

    private static int N,min;
    private static int[][] map;
    private static boolean[] visited;

    private static void dfs(int depth) {
        // map[i][j] + map[j][i];
        // 한쪽이 스타트 팀이면 다른쪽은 링크 팀이다

        if(depth == N) {
            // min = Math.min()
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                String[] readLine = br.readLine().split(" ");
                for (int j = 0; j < readLine.length; j++) {
                    map[i][j] = Integer.parseInt(readLine[j]);
                }
            }

        }
    }
}
