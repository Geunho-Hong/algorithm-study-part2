package guenho.practice;

/**
 * BFS 알고리즘 정리
 * 1. 시작 정점을 Queue에 add 하고 방문 처리 한다
 * 2. Queue에서 꺼내며 인접한 정점을 큐에 저장한 후, 방문 처리 한다
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Tip
 * 1. Queue에 넣는 순간 방문 처리 한다
 * 2. 상,하,좌,우 4 방향을 돌며 (경우에 따라 대각선 추가)
 * 조건을 비교 한다
 * 큐에서 꺼낸 정점의 위치에서 4방향을 돌며 조건에 맞으면 큐에 넣는다
 * 또한, 재귀가 아니기 때문에 네 방향을 돌며 조건을 만족하는걸 모두 큐에 넣고 차례로 진행한다
 * 즉, 조건을 만족하면 큐에 마지막에 저장되기 떄문에 이전에 있던 큐를 먼저 처리해야 한다
 * * bfs는 말그대로 퍼져나가는 개념이다
 * * dfs의 경우에는 조건을 만족하는게 발견될 경우 파고드는 개념이다
 */

public class BfsTest {

    private static boolean[][] visited;
    private static int[][] map;
    private static int N;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static void bfs(int x, int y) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node nextNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = nextNode.x + dx[i];
                int nY = nextNode.y + dy[i];

                if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
                    if(!visited[nX][nY]) {
                        queue.add(new Node(nX,nY));
                        visited[nX][nY] = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
