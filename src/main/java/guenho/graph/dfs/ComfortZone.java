package guenho.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 주의사항 : 각 영역의 높이를 기준으로 문제를 풀면 안된다.

public class ComfortZone {

    private static int N, H;
    private static int[][] graph;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;

            if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
                if (visited[nX][nY] == false && graph[nX][nY] > H) {
                    // 물에 잠긴 영역이라면 -> 안에 조건식이 잘못됨
                    dfs(nX, nY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> heights = new HashSet<Integer>();
        ArrayList<Integer> answerList = new ArrayList<Integer>();

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];


        for (int i = 0; i < N; i++) {
            String[] rowStr = br.readLine().split(" ");
            for (int j = 0; j < rowStr.length; j++) {
                graph[i][j] = Integer.parseInt(rowStr[j]);
                heights.add(graph[i][j]);
            }
        }

        int max = Collections.max(heights);

        // 높이가 안 잠길 수 있기 떄문에 0으로 표현
        for(int i = 0;  i <max; i ++) {

            H = i;

            visited = new boolean[N][N];
            int cnt = 0;

            // 이식이 필요없는이유 -> dfs 내부에서 방문 처리
            /*for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (H >= graph[j][k]) {
                        // 높이 만큼 작은 Comfort Zone을 방문 처리 한다
                        visited[j][k] = true;
                    }
                }
            }*/

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (graph[j][k] > H && visited[j][k] == false) {
                        cnt++;
                        dfs(j, k);
                    }
                }
            }

            answerList.add(cnt);

        }

        System.out.print(Collections.max(answerList));

    }
}
