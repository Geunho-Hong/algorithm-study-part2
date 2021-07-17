package min.graph.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Alphabet {

    static int r;
    static int c;

    static char[][] board;
    static Set<Character> passed = new HashSet<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int branchCnt = 0;
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        r = scanner.nextInt();
        c = scanner.nextInt();

        board = new char[r][c];

        scanner.nextLine();

        for (int i = 0; i < r; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int x, int y) {
        branchCnt++;
        passed.add(board[x][y]);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (passed.contains(board[nx][ny])) continue;

            dfs(nx, ny);
        }
        result = Math.max(result, branchCnt--);
        passed.remove(board[x][y]);
    }

}