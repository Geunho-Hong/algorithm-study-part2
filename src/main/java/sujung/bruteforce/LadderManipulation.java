package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class LadderManipulation {
    private static int N, M, H;
    private static boolean[][] map;
    private static int result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());   // 세로선 (열)
            M = parseInt(st.nextToken());   // 가로선 개수
            H = parseInt(st.nextToken());   // 높이 (행)

            map = new boolean[H][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int x = parseInt(st.nextToken());
                int y = parseInt(st.nextToken());
                map[x - 1][y - 1] = true;
            }

            result = Integer.MAX_VALUE;

            for (int i = 0; i <= 3; i++) {
                go(0, 0, 0, i);
                if (result == i) {
                    break;
                }
            }

            System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        }
    }

    /**
     * i번 세로선의 결과가 i번이 나올 수 있도록 추가해야 하는 가로선 개수의 최솟값을 구한다.
     * (가능한 모든 가로선의 경우를 완전 탐색함)
     *
     * @param x
     * @param y
     * @param count
     * @param limit
     */
    private static void go(int x, int y, int count, int limit) {
        if (result == limit || count > limit) {     // pruning
            return;
        }
        if (count == limit) {
            if (isEqualAllAfterClimbDown()) {
                result = limit;
            }
            return;
        }

        for (int i = x; i < H; i++) {
            for (int j = (i == x ? y : 0); j < N - 1; j++) {
                if (map[i][j]) continue;                // current
                if (j >= 1 && map[i][j - 1]) continue;  // left
                if (map[i][j + 1]) continue;            // right

                map[i][j] = true;
                go(i, j, count + 1, limit);
                map[i][j] = false;
            }
        }
    }

    /**
     * 모든 세로선에 대해 i번 세로선의 결과가 i가 되는지 판별한다.
     *
     * @return
     */
    private static boolean isEqualAllAfterClimbDown() {
        for (int y = 0; y < N; y++) {
            int tempY = y;

            for (int x = 0; x < H; x++) {
                if (map[x][tempY]) {
                    tempY++;
                } else if (tempY >= 1 && map[x][tempY - 1]) {
                    tempY--;
                }
            }
            if (tempY != y) {
                return false;
            }
        }
        return true;
    }
}
