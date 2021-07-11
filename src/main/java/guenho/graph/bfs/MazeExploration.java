package guenho.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/2178
// 최소 칸의 개수 -> BFS

public class MazeExploration {

    private static int [][] graph;
    private static boolean [][] visited;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int N;
    private static int M;

    private static void bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {

            Node nextNode = queue.poll();
            int qX = nextNode.x;
            int qY = nextNode.y;

            for (int i = 0; i < 4; i++) {
                int nX = nextNode.x + dx[i];
                int nY = nextNode.y + dy[i];
                if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
                    if (graph[nX][nY] == 1 && visited[nX][nY] == false) {
                        queue.offer(new Node(nX, nY));
                        visited[nX][nY] = true;
                        graph[nX][nY] = graph[qX][qY] + 1;   // 이동시 : 다음좌표 = 현재좌표 값 + 1;
                        // 이미 이동한 좌표 -> nX,nY는 다음 좌표 값 만 고려

                        //sysout();
                        //System.out.println("=====================");
                    }
                }
            }
        }
    }

    public static void sysout(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0 ; i < N; i++) {
            String[] rowStr =  br.readLine().split("");
            for (int j = 0; j < rowStr.length; j++) {
                graph[i][j] = Integer.parseInt(rowStr[j]);
            }
        }

        bfs(0,0);
        System.out.println(graph[N-1][M-1]);

    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
