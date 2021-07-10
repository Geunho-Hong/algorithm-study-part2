package min.graph.dfs;

import java.util.Scanner;

public class SafeZone {

    static int n;
    static int[][] graph;
    static int[][] tempGraph;

    static int rainHeight;

    private static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= n)
            return false;

        if (tempGraph[x][y] <= rainHeight) // 안전지대 아님
            return false;

        tempGraph[x][y] = -1;
        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        scanner.nextLine();

        graph = new int[n][n];
        tempGraph = new int[n][n];

        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
                max = Math.max(max, graph[i][j]);
            }
        }

        int maxSafeCount = 0;
        for (int h = 0; h <= max; h++) { // 높이가 1 ~ 100 이기 때문에 100번 모두 검사
            rainHeight = h;
            copyTempArray();
            int safeCount = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (dfs(x, y)) {
                        safeCount++;
                    }
                }
            }
            maxSafeCount = Math.max(maxSafeCount, safeCount);
        }
        System.out.println(maxSafeCount);
    }

    private static void copyTempArray() {
        for (int i = 0; i < n; i++)
            System.arraycopy(graph[i], 0, tempGraph[i], 0, graph[i].length);
    }

}
