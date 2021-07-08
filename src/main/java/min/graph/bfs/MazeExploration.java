package min.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class MazeExploration {

    static int[][] graph;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    static int n;
    static int m;

    static int goalX;
    static int goalY;

    // 도착치 = n - 1, m - 1
    private static int bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(x, y, 1));
        graph[x][y] = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == goalX && point.y == goalY) // 목표 지점 도착 시 count 반환
                return point.count;

            for (int i = 0; i < 4; i++) {
                int nx = point.x + mx[i];
                int ny = point.y + my[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    queue.offer(new Point(nx, ny, point.count + 1));
                    graph[nx][ny] = 0;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        goalX = n - 1;
        goalY = m - 1;
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
