package sujung.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Alphabet {

    private static int R, C;
    private static char[][] map;
    private static boolean[] alphabet;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            initMap(br);

            go(0, 0, 1);
            System.out.println(max);
        }
    }

    private static void go(int x, int y, int length) {
        // Compute max length
        if (length > max) {
            max = length;
            if (length >= R * C) {  // Base case & Pruning
                return;
            }
        }

        alphabet[map[x][y] - 'A'] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < R && 0 <= ny && ny < C && !alphabet[map[nx][ny] - 'A']) {
                go(nx, ny, length + 1);
            }
        }
        alphabet[map[x][y] - 'A'] = false;
    }

    private static void initMap(BufferedReader br) throws IOException {
        String[] size = br.readLine().split(" ");
        R = Integer.parseInt(size[0]);
        C = Integer.parseInt(size[1]);
        map = new char[R][C];
        alphabet = new boolean[26];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}
