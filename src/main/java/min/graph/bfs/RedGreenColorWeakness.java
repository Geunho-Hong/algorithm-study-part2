package min.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RedGreenColorWeakness {

    static int n;

    static char[][] normalDrawing;
    static char[][] weaknessDrawing;

    static boolean[][] normalVisited;
    static boolean[][] weaknessVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int normal;
    static int weakness;

    public static void main(String[] args) throws IOException {
        initMap();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!normalVisited[i][j]) {
                    dfs(i, j, normalDrawing, normalVisited);
                    normal++;
                }

                if (!weaknessVisited[i][j]) {
                    dfs(i, j, weaknessDrawing, weaknessVisited);
                    weakness++;
                }
            }
        }
        System.out.println(normal);
        System.out.println(weakness);
    }

    static void dfs(int x, int y, char[][] drawing, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (drawing[x][y] != drawing[nx][ny] || visited[nx][ny]) continue;

            dfs(nx, ny, drawing, visited);
        }
    }

    static void weakness(int x, int y) {
        normalVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        }
    }

    static void initVisited() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(normalVisited[i], false);
        }
    }

    static void initMap() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());

            normalDrawing = new char[n][n];
            weaknessDrawing = new char[n][n];

            normalVisited = new boolean[n][n];
            weaknessVisited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String colors = br.readLine();
                for (int j = 0; j < n; j++) {
                    char color = colors.charAt(j);
                    normalDrawing[i][j] = color;
                    if (color != 'B')
                        weaknessDrawing[i][j] = 'W';
                    else
                        weaknessDrawing[i][j] = color;
                }
            }
        }
    }

}