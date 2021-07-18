package guenho.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Cheese {

    private static int N, M, cheese, answer, time;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] graph;
    private static boolean[][] visited;
    private static int checkCnt = 0;

    // dfs를 돌면서 0이면 -> 외부공기 -> -1
    // dfs를 돌면서 다음 이동 장소가 치즈면 값 + 1
    // 3이상의 값이면 2면 이상이 공기와 접촉된 치즈 -> 0 으로 처리

    private static boolean cheeseSolve() {
        checkCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 || graph[i][j] == 2) {
                    // 해당 좌표의 치즈 값이 3면 미만으로 닿아있다면 원래 치즈 값 처리
                    graph[i][j] = 1;
                    checkCnt++;
                } else {
                    // 치즈 녹여주기
                    graph[i][j] = 0;
                }
            }
        }
        return checkCnt == 0;
    }

    public static void dfs(int x, int y) {

        // 값이 공기(0) 라면 -1
        graph[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;

            if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
                if (graph[nX][nY] == 0) {
                    // 방문하지 않은 공기(0) 라면 dfs
                    dfs(nX, nY);
                } else if (graph[nX][nY] > 0) {
                    // 치즈가 존재하는 값이라면 값 증가
                    graph[nX][nY]++;
                }
                //sysOutGraph();
            }
        }
    }

    private static void sysOutGraph() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] rowStr = br.readLine().split(" ");
            for (int j = 0; j < rowStr.length; j++) {
                graph[i][j] = Integer.parseInt(rowStr[j]);
            }
        }

        int answer = 0;

        while (!cheeseSolve()) {
            dfs(0, 0);
            //sysOutGraph();
            answer++;
        }

        System.out.println(answer);
    }

}
