package sujung.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class RedGreenBlindness {

    private static int N;
    private static char[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            initMap(br);

            OpticalCheckups blindness = new OpticalCheckups(true);
            int resultOfBlindness = blindness.inspect();

            OpticalCheckups general = new OpticalCheckups(false);
            int resultOfGeneral = general.inspect();

            System.out.println(resultOfGeneral + " " + resultOfBlindness);
        }
    }

    private static void initMap(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    private static class OpticalCheckups {

        private boolean[][] visited;
        private int countOfArea;
        private boolean isRedGreenBlindness;

        public OpticalCheckups(boolean isRedGreenBlindness) {
            this.visited = new boolean[N][N];
            this.countOfArea = 0;
            this.isRedGreenBlindness = isRedGreenBlindness;
        }

        public int inspect() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j, map[i][j]);
                        countOfArea++;
                    }
                }
            }
            return countOfArea;
        }

        public void dfs(int x, int y, char prevColor) {
            visited[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                char curColor = map[nx][ny];
                if (visited[nx][ny]) continue;

                if (prevColor == curColor || (isRedGreenBlindness && prevColor + curColor == 'R' + 'G')) {
                    dfs(nx, ny, map[nx][ny]);
                }

            }
        }
    }
}
