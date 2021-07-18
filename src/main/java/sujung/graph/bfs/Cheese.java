package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.in;

public class Cheese {

    private static int N, M;
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            initMap(br);

            int time = 0;
            while (count > 0) {
                bfs();
                time++;
            }

            System.out.println(time);
        }
    }

    private static void bfs() {
        // Spread air -> Count cheese to be melted
        visited = new int[N][M];

        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0 && visited[nx][ny] == 0) {  // Air
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = 1;
                } else if (map[nx][ny] == 1) {                  // Cheese
                    visited[nx][ny]++;
                    if (visited[nx][ny] >= 2) {                 // Being melted
                        map[nx][ny] = 0;
                        count--;
                    }
                }
            }
        }
    }

    private static void initMap(BufferedReader br) throws IOException {
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);

                // Count Cheese
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
    }

    private static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
