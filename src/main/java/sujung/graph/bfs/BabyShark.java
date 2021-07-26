package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import static java.lang.System.in;

public class BabyShark {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int sx, sy, sizeOfShark, countOfHunt;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            initMap(br);

            System.out.println(bfs());
        }
    }

    private static int bfs() {
        int time = 0;

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(sx, sy, 0));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {

            Point cur = queue.poll();

            if (0 < map[cur.x][cur.y] && map[cur.x][cur.y] < sizeOfShark) {

                // Hunt prey
                map[cur.x][cur.y] = 0;
                countOfHunt++;
                if (countOfHunt == sizeOfShark) {
                    sizeOfShark++;
                    countOfHunt = 0;
                }
                time += cur.distance;

                // Initialize for next round
                while (!queue.isEmpty()) {
                    queue.poll();
                }
                visited = new boolean[N][N];
                visited[cur.x][cur.y] = true;
                cur.distance = 0;
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sizeOfShark) continue;

                queue.offer(new Point(nx, ny, cur.distance + 1));
                visited[nx][ny] = true;
            }
        }

        return time;
    }

    private static void initMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);

                // Initialize baby info
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    sx = i;
                    sy = j;
                    sizeOfShark = 2;
                    countOfHunt = 0;
                }
            }
        }
    }

    private static class Point implements Comparable<Point> {
        private int x;
        private int y;
        private int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                }
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.distance, o.distance);
        }
    }
}
