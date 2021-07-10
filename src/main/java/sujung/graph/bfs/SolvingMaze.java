package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class SolvingMaze {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            initMap(br);

            Deque<Point> queue = new ArrayDeque<>();
            map[0][0] = 2;
            queue.offer(new Point(0, 0));

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                if (cur.x == N - 1 && cur.y == M - 1) {
                    System.out.println(map[cur.x][cur.y] - 1);
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (map[nx][ny] != 1) continue;

                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    queue.offer(new Point(nx, ny));
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
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j] - '0';
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
