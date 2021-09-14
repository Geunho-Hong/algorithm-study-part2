package guenho.graph.dfs;

// 관련 URL : https://www.acmicpc.net/problem/2667
// DFS (Depth-find Search) : Stack or Recursion

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class EstateNumberingDFS {

    private static int N;
    private static int[] dx = {0, 0, 1, -1};  // X 좌표
    private static int[] dy = {1, -1, 0, 0};  // Y 좌표
    private static int[][] graph;
    private static boolean[][] visited;
    private static int cnt = 1;

    public static int dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;     // 다음 x 좌표
            int nY = dy[i] + y;     // 다음 y 좌표

            if (nX>=0 && nY >=0 && nX < N && nY < N) {
                // 그래프가 연결되어있고, 방문하지 않았다면
                // 1. 좌표 범위를 벗어나지 않아야 한다
                // 2. 방문하지 않아야 한다
                if (graph[nX][nY] == 1 && visited[nX][nY] == false) {
                    // 상,하,좌,우 네 방향을 돌며, 좌표가 그래프 범위 안에 있으면 DFS 방문 처리
                    System.out.println("현재 : " + x + "," + y);
                    System.out.println("다음 : " + nX + "," + nY);
                    dfs(nX, nY);
                    // dfs가 종료 될 때 밑에 로직을 탄다
                    cnt++;
                    System.out.println("cnt :" + cnt);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> countList = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] mapRow = br.readLine().split("");
            for (int j = 0; j < mapRow.length; j++) {
                graph[i][j] = Integer.parseInt(mapRow[j]);
            }
        }

        for(int i= 0; i<N ; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && visited[i][j] == false) {
                    // 그래프가 1로 연걸되어있고, 방문하지 않았다면 연결
                    System.out.println("graph = " + i + "," + j);
                    countList.add(dfs(i, j));
                    System.out.println("fin");
                    cnt = 1;
                    answer++;
                }
            }
        }

        Collections.sort(countList);

        // 총 단지수
        System.out.println(answer);

        // 단지 마다 갯수
        for (int cnt : countList) {
            System.out.println(cnt);
        }
    }
}
