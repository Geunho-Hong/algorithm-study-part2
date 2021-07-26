package guenho.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 참고 : https://hongjw1938.tistory.com/132
// 참고 2 : https://hong-kee.github.io/algorithm/2146-post/
// https://www.acmicpc.net/problem/2146

/**
 * MakeBride
 * 1. 각각의 섬 구별
 * 2. 도착한 대륙이 출발한 대륙과 일치하지 않으면 다리를 놓음
 */

public class MakeBridge {

    private static int N, cnt,  islandCnt =1 , min = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    // 0은 바다, 1은 육지

    private static void makeIsland(int x, int y) {

        map[x][y] = islandCnt;
        visited[x][y] = true;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y,0));

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nX = dx[i] + currentNode.x;
                int nY = dy[i] + currentNode.y;

                if (nX >= 0 && nY >= 0 & nX < N && nY < N) {
                    if (!visited[nX][nY] && map[nX][nY] != 0) {
                        map[nX][nY] = islandCnt;
                        visited[nX][nY] = true; // Recursive는 없어도 되지만 visited는 존재해야 한다
                        queue.offer(new Node(nX,nY,0));
                    }
                }
            }
        }
    }

    private static void makeBridge(int x , int y) {

        int bridgeNum = map[x][y];  // 현제 좌표 값
        visited[x][y] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x,y,0));

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = currentNode.x + dx[i];
                int nY = currentNode.y + dy[i];
                int depth = currentNode.depth;

                if(nX>=0 && nY>=0 && nX <N && nY < N) {
                    if(!visited[nX][nY]) {
                        if(map[nX][nY] == 0) {
                            //System.out.println("depthreal :" + depth+1);
                            // 0이면 계속해서 값을 증가하면서 증가
                            queue.offer(new Node(nX,nY, depth+1));
                            visited[nX][nY] = true;
                        } else if (map[nX][nY] != bridgeNum){
                            // 다른 섬을 찾았다면 최단 거리를 Return
                            min = Math.min(depth,min);
                            return;
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];


        initMap(br);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    makeIsland(i,j);
                    islandCnt++;
                }
            }
        }
        visited = new boolean[N][N];
        //sysOutMap();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 0){
                    makeBridge(i,j);
                    visited = new boolean[N][N];    // bfs 이후 방문 초기화
                }
            }
        }
        System.out.println(min);
    }

    private static void initMap(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(rows[j]);
            }
        }
    }


    private static void sysOutMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==========================");
    }

    // Node
    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

}
