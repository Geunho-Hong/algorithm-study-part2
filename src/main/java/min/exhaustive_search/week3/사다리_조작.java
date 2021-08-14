package min.exhaustive_search.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사다리_조작 {

    static int n, m, h;
    static int[][] map;

    static int result;

    public static void main(String[] args) throws IOException {
        init();

        result = 4;
        dfs(0, 1, 1);
        if (result == 4) result = -1;
        System.out.println(result);
    }

    static void dfs(int count, int y, int x) {
        if (count >= result) return;
        if (check()) {
            result = count;
            return;
        }
        if (count == 3) return;

        for (int i = y; i <= h; i++) {
            for (int j = x; j < n; j++) {
                if (map[i][j] == 0 && map[i][j - 1] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1, i, j);
                    map[i][j] = 0;
                }
            }
            x = 1;
        }
    }

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            int pos = i;

            for (int j = 0; j <= h; j++) {
                if (map[j][pos] == 1) {
                    ++pos;
                } else if (map[j][pos - 1] == 1) {
                    --pos;
                }
            }

            if (pos != i) {
                return false;
            }
        }
        return true;
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            m = Integer.parseInt(inputs[1]);
            h = Integer.parseInt(inputs[2]);

            map = new int[h + 1][n + 1];

            if (m == 0) {
                System.out.println(0);
                System.exit(0);
            }

            for (int i = 0; i < m; i++) {
                inputs = br.readLine().split(" ");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);

                map[a][b] = 1;
            }
        }
    }
}