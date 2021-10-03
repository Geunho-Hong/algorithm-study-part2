package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Tomato {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int unripe;
    private static Queue<Point> queue;

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = parseInt(st.nextToken());
            N = parseInt(st.nextToken());
            map = new int[N][M];
            unripe = 0;
            queue = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = parseInt(st.nextToken());
                    if (map[i][j] == 1) {   // 이미 익은 토마토 선별
                        queue.offer(new Point(i, j));
                    } else if (map[i][j] == 0) {
                        unripe++;
                    }
                }
            }

            // 토마토를 익힌다. (익은 토마토의 상하좌우 토마토를 익혀버림)
            int days = ripenTomato();

            // 토마토가 모두 익을 때까지의 최소 날짜 출력
            // 아직도 안 익은 놈이 있다면 -1, 아니라면 익힌 회차 - 1
            System.out.println(unripe > 0 ? -1 : days - 1);
        }
    }

    private static int ripenTomato() {
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point current = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = current.x + dx[k];
                    int ny = current.y + dy[k];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = 1;
                            unripe--;   // 이제 익음
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            days++;
        }
        return days;
    }
}
