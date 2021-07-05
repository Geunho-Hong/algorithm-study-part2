package min.graph;

import java.util.Scanner;

public class FreezeDrinks_DFS {

    static int n, m;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) result++;
            }
        }

        System.out.println(result);
    }

    private static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= m)
            return false;

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}
