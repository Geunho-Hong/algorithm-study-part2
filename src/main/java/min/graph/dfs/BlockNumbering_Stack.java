package min.graph.dfs;

import java.util.*;

public class BlockNumbering_Stack {

    static int n;
    static int[][] graph;
    static int count;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    private static boolean dfs_stack(int x, int y) {
        if (graph[x][y] == 0)
            return false;

        Deque<Point> stack = new ArrayDeque<>();
        stack.push(new Point(x, y));
        graph[x][y] = 0;
        count++;
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + mx[i];
                int ny = p.y + my[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (graph[nx][ny] == 1) {
                    stack.push(new Point(nx, ny));
                    graph[nx][ny] = 0;
                    count++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        scanner.nextLine();

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs_stack(i, j)) {
                    result.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(System.out::println);
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
