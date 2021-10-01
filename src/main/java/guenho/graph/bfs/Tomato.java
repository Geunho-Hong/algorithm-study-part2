package guenho.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 익은 토마토를 동시에 고려해 줘야 한다

public class Tomato {

    private static int N, M;
    private static int[][] tomato;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        // 0 : 익지 않은 토마토
        // 1 : 익은 토마토
        // -1 : 토마토가 들어 있지 않은 칸
        // 모두 익지 못하는 상황 -> -1

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            M = Integer.parseInt(commands[1]);

            tomato = new int[M][N];

            for (int i = 0; i < M; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    tomato[i][j] = Integer.parseInt(line[j]);
                }
            }
            bfs();
        }
    }

    private static void bfs() {

        /**
         * 익은 토마토를 동시에 고려해 줘야 한다.
         * 즉, 특정 좌표를 기준으로 bfs를 돌리는 것이 아니라
         * 익은 토마토의 좌표를 Queue에 모두 삽입해 구현 한다.
         */

        /**
         * bfs -> depth는 큐에서 꺼낸 정점위치에서 얼마만큼 depth를 갔는지
         * dfs -> 재귀의 횟수 (dfs자체가 완탐이기에)
         */

        int day = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(tomato[i][j] == 1) {
                    queue.offer(new Node(i, j, day));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            day = node.day;
            

            for (int i = 0; i < 4; i++) {
                int nX = node.x + dx[i];
                int nY = node.y + dy[i];

                if (nX >= 0 && nY >= 0 && nX < M && nY < N) {
                    if (tomato[nX][nY] == 0) {
                        tomato[nX][nY] = 1;
                        queue.add(new Node(nX, nY, day + 1));
                    }
                }
            }
        }

        if(matoCheck()) {
            System.out.println(day);
        } else {
            System.out.println("-1");
        }

    }

    private static boolean matoCheck() {
        boolean flag = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    flag = false;
                }
            }
        }
        return flag;
    }


    // Node
    static class Node {
        private int x;
        private int y;
        private int day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
