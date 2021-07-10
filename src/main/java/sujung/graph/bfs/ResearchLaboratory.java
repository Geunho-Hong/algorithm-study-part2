package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class ResearchLaboratory {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int BLANK;
    private static int answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            initMap(br);

            buildWall(0, 0, 0);

            System.out.println(answer);
        }
    }

    private static void initMap(BufferedReader br) throws IOException {
        String[] size = br.readLine().split(" ");

        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        map = new int[N][M];

        answer = 0;
        BLANK = 0;

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                if (map[i][j] == 0) {
                    BLANK++;
                }
            }
        }
    }

    private static void buildWall(int x, int y, int newWall) {
        if (newWall == 3) {
            int virus = spreadVirus();
            int countOfSafety = BLANK - newWall - virus;
            answer = Math.max(answer, countOfSafety);

            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(i, j, newWall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int spreadVirus() {
        visited = new boolean[N][M];
        Deque<Point> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                }
            }
        }

        int newvirus = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                    newvirus++;
                }
            }
        }
        return newvirus;
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
