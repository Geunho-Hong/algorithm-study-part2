package min.queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CastleOnTheGrid {

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();

        // 노드 생성
        Node[][] nodes = new Node[n][n];

        for (int x = 0; x < n; x++) {
            String xLine = grid.get(x);
            for (int y = 0; y < n; y++) {
                char c = xLine.charAt(y);
                if (c == '.') {
                    Node node = new Node(x, y);
                    nodes[x][y] = node;
                }
            }
        }

        // 시작 노드로부터 동서남북으로 방문하지 않은 인접한 노드를 모두 queue 에 담고, visited 는 true로 변경한다.  (level = 1)
        // queue에 담겨있는 노드를 하나씩 꺼내며 1번 반복 (모든 인접 노드를 꺼내면 레벨 1씩 증가)
        // 꺼낸 노드의 포지션이 목표 x,y와 같다면 현재 level 반환
        Queue<Node> queue = new ArrayDeque<>();
        Node startNode = nodes[startX][startY];
        startNode.visit();
        queue.offer(startNode);

        int level = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            // 동
            while (++y < n) {
                Node e = nodes[x][y];
                if (e == null) {
                    break;
                } else if (e.isEqualPosition(goalX, goalY)) {
                    return node.level + 1;
                }

                if (!e.visited) {
                    queue.offer(e);
                    e.visit();
                    e.increaseLevel(node);
                }
            }
            y = node.y;

            // 서
            while (--y >= 0) {
                Node e = nodes[x][y];
                if (e == null) {
                    break;
                } else if (e.isEqualPosition(goalX, goalY)) {
                    return node.level + 1;
                }

                if (!e.visited) {
                    queue.offer(e);
                    e.visit();
                    e.increaseLevel(node);
                }
            }
            y = node.y;

            // 남
            while (++x < n) {
                Node e = nodes[x][y];
                if (e == null) {
                    break;
                } else if (e.isEqualPosition(goalX, goalY)) {
                    return node.level + 1;
                }

                if (!e.visited) {
                    queue.offer(e);
                    e.visit();
                    e.increaseLevel(node);
                }
            }
            x = node.x;

            // 북
            while (--x >= 0) {
                Node e = nodes[x][y];
                if (e == null) {
                    break;
                } else if (e.isEqualPosition(goalX, goalY)) {
                    return node.level + 1;
                }

                if (!e.visited) {
                    queue.offer(e);
                    e.visit();
                    e.increaseLevel(node);
                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;
        boolean visited;
        int level;
        List<Node> adjacencyList;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.level = 0;
            this.visited = false;
            this.adjacencyList = new LinkedList<>();
        }

        public boolean isEqualPosition(int x, int y) {
            return this.x == x && this.y == y;
        }

        public void visit() {
            this.visited = true;
        }

        public void increaseLevel(Node node) {
            this.level = node.level + 1;
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);
        int startY = Integer.parseInt(firstMultipleInput[1]);
        int goalX = Integer.parseInt(firstMultipleInput[2]);
        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = CastleOnTheGrid.minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println("result = " + result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

}
