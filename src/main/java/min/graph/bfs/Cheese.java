package min.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Cheese {

    static int n;
    static int m;

    static int[][] paper;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }

        int result = 0;
        while (true) {
            // 0이면 2로 변경
            findRoomTemperature();

            // 1이면 네개의 면 검사 후 두개의 면 이상이 실온이면 9로 변경
            findMeltingCheese();

            // 치즈 제거
            if (meltCheese())
                break;

            // 시간 + 1
            result++;
        }

        System.out.println(result);
    }

    static void findRoomTemperature() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        paper[0][0] = 2;

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 아직 방문하지 않았고 치즈가 아니면 실온으로 변경
                if (!visited[nx][ny] && paper[nx][ny] != 1) {
                    queue.offer(new Point(nx, ny));
                    paper[nx][ny] = 2;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void findMeltingCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        // 실온이면 count 증가
                        if (paper[nx][ny] == 2) count++;
                    }
                    // 녹을 치즈를 9로 표시
                    if (count >= 2) paper[i][j] = 9;
                }
            }
        }
    }

    static boolean meltCheese() {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 9) {
                    paper[i][j] = 2;
                    flag = false;
                }
            }
        }
        return flag;
    }

    ////// Class //////

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
