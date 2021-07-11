package min.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Lab {

    static int n;
    static int m;

    static int[][] lab;
    static int[][] tempLab;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int maxSafeZone;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 연구소 상황 입력 받기
        n = scanner.nextInt();
        m = scanner.nextInt();

        lab = new int[n][m];
        tempLab = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lab[i][j] = scanner.nextInt();
            }
        }

        copyLab();

        buildWall(0);

        System.out.println(maxSafeZone);
    }

    private static void spreadVirus() {
        // 4. 바이러스(2)를 퍼뜨린다. -> BFS -> 1이 아닌 공간을 2로 채운다.
        Queue<Point> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempLab[i][j] == 2) { // 바이러스를 큐에 저장
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        // 5. 안전 구역(0)의 개수를 센다. 2중 for 문
        countSafeZone(tempLab);
    }

    private static void countSafeZone(int[][] labs) {
        int count = 0;
        for (int[] lab : labs) {
            for (int space : lab) {
                if (space == 0) count++;
            }
        }

        // 6. BFS가 완료될 때마다 안전 구역의 최대 개수를 비교하여 갱신한다.
        maxSafeZone = Math.max(maxSafeZone, count);
    }

    private static void buildWall(int wallCount) {
        if (wallCount == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 벽은 0인 공간만 세울 수 있음
                if (tempLab[i][j] == 0) {
                    tempLab[i][j] = 1; // 벽을 세움
                    buildWall(wallCount + 1); // 벽이 3개면 바이러스 확산시키고 나옴
                    tempLab[i][j] = 0; // 바이러스 확산 시켜본 후 다음 공간에 벽을 세우기 위해 벽을 허뭄
                }
            }
        }
    }

    private static void copyLab() {
        for (int i = 0; i < n; i++) {
            System.arraycopy(lab[i], 0, tempLab[i], 0, lab[i].length);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
