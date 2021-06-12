package sujung.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CastleOnTheGrid {

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static final char WALL = 'X';
    private static final char VISITED = 'O';

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int N = grid.size();
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = grid.get(i);
            map[i] = row.toCharArray();
        }

        Deque<Point> queue = new ArrayDeque<>();
        map[startX][startY] = VISITED;
        queue.offer(new Point(startX, startY, 0));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == goalX && current.y == goalY) {
                return current.moveCount;
            }
            for (int k = 0; k < 4; k++) {
                int nx = current.x;
                int ny = current.y;
                while (true) {
                    nx += dx[k];
                    ny += dy[k];
                    if (0 <= nx && nx <= N - 1 && 0 <= ny && ny <= N - 1 && map[nx][ny] != WALL) {
                        if (nx == goalX && ny == goalY) return current.moveCount + 1;
                        if (map[nx][ny] != VISITED) continue;
                        map[nx][ny] = VISITED;
                        queue.offer(new Point(nx, ny, current.moveCount + 1));
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    private static class Point {
        private int x;
        private int y;
        private int moveCount;

        public Point(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }
}
