package min.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BuildBridge {

    static int n;

    static int[][] country;
    static boolean[][] visited;

    static int minBridgeCount = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        initMap();

        numberingIsland();

        buildBridge();

        System.out.println(minBridgeCount);
    }

    static void buildBridge() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (country[i][j] != 0) {
                    initVisited();
                    bfs(i, j, country[i][j]);
                }
            }
        }
    }

    static void initVisited() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static void bfs(int x, int y, int islandNumber) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (country[nx][ny] != 0 && country[nx][ny] != islandNumber) {
                    minBridgeCount = Math.min(minBridgeCount, current.distance);
                    // 가장 가까운 다른 섬을 찾았으면 더이상 bfs를 돌 필요가 없다.
                    return;
                }

                queue.offer(new Point(nx, ny, current.distance + 1));
                visited[nx][ny] = true;
            }
        }
    }

    static void numberingIsland() {
        visited = new boolean[n][n];

        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (country[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, number++);
                }
            }
        }
    }

    static void dfs(int x, int y, int number) {
        country[x][y] = number;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (country[nx][ny] == 0 || visited[nx][ny]) continue;

            dfs(nx, ny, number);
        }
    }

    static void initMap() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            country = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] arr = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    country[i][j] = Integer.parseInt(arr[j]);
                }
            }
        }
    }

    // Class //
    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y) {
            this(x, y, 0);
        }

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}