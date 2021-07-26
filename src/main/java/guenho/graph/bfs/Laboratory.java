package guenho.graph.bfs;

// 높은 난이도의 문제 dfs,bfs 모두 활용해서 Brute forth 방식으로 문제를 풀어야 한다
// https://www.acmicpc.net/problem/14502

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Laboratory {

    private static int[][] graph;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int answer;
    private static int safetyCnt;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int wallCnt;
    private static int virusCnt;


    // spreadVirusCnt Queue에 담기는 의미??
    // 시작 정점을 모두 담고 처리 ??

    public static int spreadVirus() {

        visited = new boolean[N][M];
        Deque<Node> queue = new ArrayDeque<>();

        // virus를 돌릴 초기 Node 값 Queue에 담기
        for(int i =0; i<N; i ++) {
            for(int j=0; j<M; j ++) {
                if(graph[i][j] == 2) {
                    // 해당 요소가 virus 라면 방문처리
                    queue.offer(new Node(i,j));
                }
            }
        }

        int virusCnt = 0;

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + currentNode.x;
                int nY = dy[i] + currentNode.y;
                if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
                    if (visited[nX][nY] == false && graph[nX][nY] == 0) {
                        // 벽이 세어지지 않은 영역에 대해 virus 확산
                        visited[nX][nY] = true;
                        queue.offer(new Node(nX,nY));
                        virusCnt++;
                    }
                }
            }
        }
        return virusCnt;
    }

    public static void makeWall(int x, int y, int wallCnt) {

        if(wallCnt == 3) {
            // 벽의 개수가 3개 -> Virus Spread
            int virusCnt = spreadVirus();
            int cnt = safetyCnt - wallCnt - virusCnt;
            answer = Math.max(answer,cnt);
            return;
        }

        /**
         * 상,하,좌,우로 이동하는 것이 아니라
         * 좌표에 알맞은 값이 있다면 벽을 세운다 -> dx,dy 변수 사용 X
         */

        for (int i = x; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0 ){
                    // 벽 세우기
                    graph[i][j] = 1;
                    makeWall(i,j,wallCnt +1);
                    graph[i][j] = 0; // 방금 세운 벽 부수기
                }
            }
        }
    }

    /*public static int safeZoneCnt() {
        int safeCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0 ){
                    safeCnt ++;
                }
            }
        }
        return safeCnt;
    }*/

    public static void initMap(BufferedReader br) throws IOException {

        // 0 : 빈칸, 1: 벽 , 2: 바이러스

        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] rowStr = br.readLine().split(" ");
            for (int j = 0; j < rowStr.length; j++) {
                graph[i][j] = Integer.parseInt(rowStr[j]);
                if(graph[i][j] == 0 ){
                    safetyCnt++;
                }
            }
        }

    }

    public static void showMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            initMap(br);

            makeWall(0,0,0);
            System.out.println(answer);
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
