package guenho.graph.bfs;

// 관련 URL : https://www.acmicpc.net/problem/2667
// BFS : Queue
// 너비를 우선 탐색하기 때문에, 답이 되는 경로가 여러개임에도 최단 경로를 보장한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class EstateNumberingBFS {

    private static int N;
    private static int[] dx = {0, 0, 1, -1};  // X 좌표
    private static int[] dy = {1, -1, 0, 0};  // Y 좌표
    private static int[][] graph;
    private static boolean[][] visited;
    private static int cnt = 1;

    public static int bfs(int x, int y) {

        // x,y 좌표 각각에 대한 Queue를 만드는 것 보다 Object로 처리하는것이 효율적이다

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node nextNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = nextNode.x + dx[i];
                int nY = nextNode.y + dy[i];

                if(nX >= 0 && nY >= 0 && nX < N  && nY < N) {
                    if(graph[nX][nY] == 1 && visited[nX][nY] == false) {
                        queue.offer(new Node(nX,nY));
                        visited[nX][nY] = true;
                        cnt++;
                    }
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

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && visited[i][j] == false) {
                    // 그래프가 1로 연걸되어있고, 방문하지 않았다면 연결
                    countList.add(bfs(i, j));
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
