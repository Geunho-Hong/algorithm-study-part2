package min.graph.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlockNumbering_DFS_Recursion {

    static int n;
    static int[][] graph;
    static int count;

    private static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= n) return false;

        if (graph[x][y] == 1) {
            count++;
            graph[x][y] = 0;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }

        return false;
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

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) {
                    result.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(System.out::println);
    }
}
