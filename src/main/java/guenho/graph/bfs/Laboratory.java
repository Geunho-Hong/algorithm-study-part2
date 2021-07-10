package guenho.graph.bfs;

// https://www.acmicpc.net/problem/14502

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Laboratory {

    private static int[][] graph;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};


    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;
            if(nX >= 0 && nY >= 0 && nX < N  && nY < M ){
                if(graph[nX][nY] == 1 && visited[nX][nY] == false ){
                    dfs(nX,nY);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        // 0 : 빈칸, 1 : 벽 , 2: 바이러스

        for (int i = 0; i < N; i++) {
            String[] rowStr = br.readLine().split(" ");
            for (int j = 0; j < rowStr.length; j++) {
                graph[i][j] = Integer.parseInt(rowStr[j]);
            }
        }


    }
}
