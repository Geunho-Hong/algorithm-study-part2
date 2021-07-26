package guenho.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedGreenMadicine {

    private static int N;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    // 빨간색과 초록색의 차이를 거의 느끼지 못한다
    // R(빨강), G(초록), B(파랑)

    public static void initMap(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            String[] rows = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = rows[j];
            }
        }
    }


    public static void redGreenBfs(int x, int y) {

        visited[x][y] = true;
        String medicine = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;

            if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
                if (!visited[nX][nY] && (medicine.equals("R") || medicine.equals("G"))) {
                    // 현재 좌표 값이 적색 or 녹색의 경우
                    if (map[nX][nY].equals("R") || map[nX][nY].equals("G")) {
                        redGreenBfs(nX, nY);
                    }
                } else if (!visited[nX][nY] && medicine.equals("B")) {
                    // 파란색의 경우
                    if (!visited[nX][nY] && map[nX][nY].equals(medicine)) {
                        redGreenBfs(nX, nY);
                    }
                }
            }
        }
    }

    public static void dfs(int x, int y) {

        visited[x][y] = true;
        String medicine = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;

            if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
                if (map[nX][nY].equals(medicine) && !visited[nX][nY]) {
                    dfs(nX, nY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        visited = new boolean[N][N];

        initMap(br);

        int cnt = 0;
        int redGreenCnt = 0;

        // 적록색약이 아닌 구역의 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        visited = new boolean[N][N];

        // 적록색 양인 구역의 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    redGreenBfs(i, j);
                    redGreenCnt++;
                }
            }
        }

        System.out.println(cnt + " " + redGreenCnt);
    }
}
