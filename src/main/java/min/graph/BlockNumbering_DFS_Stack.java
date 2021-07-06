package min.graph;

import java.util.Scanner;

public class BlockNumbering_DFS_Stack {

    static int n;
    static int[][] graph;

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
    }

}
