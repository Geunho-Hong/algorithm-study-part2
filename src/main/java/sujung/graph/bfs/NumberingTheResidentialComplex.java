package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class NumberingTheResidentialComplex {
    private static int N;
    private static char[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            initMap(br);

            List<Integer> complexes = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '1') {
                        complexes.add(bfs(i, j));
                    }
                }
            }

            Collections.sort(complexes);

            System.out.println(complexes.size());
            complexes.forEach(System.out::println);
        }
    }

    private static void initMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    private static int bfs(int x, int y) {
        Deque<Point> queue = new ArrayDeque<>();
        map[x][y] = '2';
        queue.offer(new Point(x, y));

        int count = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] != '1') continue;

                map[nx][ny] = '2';
                queue.offer(new Point(nx, ny));
                count++;
            }
        }
        return count;
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
