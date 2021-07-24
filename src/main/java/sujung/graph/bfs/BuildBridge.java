package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.System.in;

public class BuildBridge {

    private static int N;
    private static int[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int islands = 1;
    private static int min = Integer.MAX_VALUE;
    private static boolean[][] visited;
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            initMap(br);

            numberingIsland();

            for (int index = 2; index <= islands; index++) {
                visited = new boolean[N][N];
                queue = new ArrayDeque<>();

                getEdgeOfIsland(index);
                computeLengthOfEdge(index);
            }
            System.out.println(min);
        }
    }

    private static void computeLengthOfEdge(int index) {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == index) continue;

                if (map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, cur.dist + 1));
                } else {  // connect another island
                    min = Math.min(min, cur.dist);
                    return;
                }
            }
        }
    }

    private static void getEdgeOfIsland(int index) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == index) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                        queue.offer(new Point(ni, nj, 1));
                        visited[ni][nj] = true;
                    }
                }
            }
        }
    }

    private static void numberingIsland() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    islands++;
                    dfs(i, j, islands);
                }
            }
        }
    }

    private static void dfs(int x, int y, int num) {
        map[x][y] = num;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 1) {
                dfs(nx, ny, num);
            }
        }
    }

    private static class Point {
        private int x;
        private int y;
        private int dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static void initMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }
}
