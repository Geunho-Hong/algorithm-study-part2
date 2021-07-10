package sujung.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SafeArea {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int MIN, MAX;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            initMap(br);


            int answer = 1;
            for (int height = MIN; height < MAX; height++) {
                visited = new boolean[N][N];
                int countOfSafe = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > height && !visited[i][j]) {
                            dfs(i, j, height);
                            countOfSafe++;
                        }
                    }
                }
                answer = Math.max(answer, countOfSafe);
            }

            System.out.println(answer);
        }
    }

    private static void initMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        MIN = 0;
        MAX = 100;

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);

                MIN = Math.min(MIN, map[i][j]);
                MAX = Math.max(MAX, map[i][j]);
            }
        }
    }

    private static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] <= height) continue;
            if (visited[nx][ny]) continue;
            dfs(nx, ny, height);
        }
    }
}
