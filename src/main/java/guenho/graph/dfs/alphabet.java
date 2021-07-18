package guenho.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 막혀있으면 돌아가야한다 -> BackTracking 문제
// 내가 푼 방식은 그냥 단순히 체크만 했을 뿐이다.

public class alphabet {

    private static char[][] alphaMap;
    private static boolean[] visited;
    private static int cnt =1, N , M;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    public static void sysOutAlphaMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(alphaMap[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int x, int y, int depth) {

        // 방문 처리
        visited[alphaMap[x][y] - 'A'] = true;
        //System.out.println("dfs init");

        for(int i = 0; i < 4; i ++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;
            if(nX >= 0 && nY >= 0 && nX < N && nY < M) {
                if(!visited[alphaMap[nX][nY] - 'A']) {
                    // 방문 처리
                    dfs(nX,nY,depth + 1);
                    // 방문 처리 제거
                    // System.out.println("dfs fin");
                    visited[alphaMap[nX][nY] - 'A'] = false;
                }
            }
        }
        cnt = Math.max(cnt,depth);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        alphaMap = new char[N][M];
        visited = new boolean[26]; // 알파벳 변수 -> 26

        for (int i = 0; i < N; i++) {
            String[] rowStr = br.readLine().split("");
            for (int j = 0; j < rowStr.length; j++) {
                alphaMap[i][j] = rowStr[j].charAt(0);
            }
        }

        int answer = 0;
        dfs(0,0,1);

        System.out.println(cnt);
    }
}
