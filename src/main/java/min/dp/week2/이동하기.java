package min.dp.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이동하기 {

    static int n, m;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");
            n = Integer.parseInt(inputs[0]);
            m = Integer.parseInt(inputs[1]);

            map = new int[n + 1][m + 1];

            /*
             * 3 4
             * 1 2 3 4
             * 0 0 0 5
             * 9 8 7 6
             *
             * 0 0  0  0  0
             * 0 1  3  6  10
             * 0 1  3  6  15
             * 0 10 18 25 31
             */

            for (int i = 1; i <= n; i++) {
                inputs = br.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    map[i][j] = Integer.parseInt(inputs[j - 1]);
                    map[i][j] += Math.max(map[i - 1][j], Math.max(map[i][j - 1], map[i - 1][j - 1]));
                }
            }
            System.out.println(map[n][m]);
        }
    }

}