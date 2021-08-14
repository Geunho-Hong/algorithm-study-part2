package guenho.exhuasive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// https://zoonvivor.tistory.com/155

public class ChickenDelivery {

    private static int N, M;
    private static int min = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] visited;
    private static LinkedList<Node> home;
    private static LinkedList<Node> chickens;

    // 각각의 집 위치에서 최소 거리에 있는 치킨집을 구한다
    private static void dfs(int count, int depth) {
        if(count == M) { //치킨 거리의 최솟값을 구한다.
            int total = 0;
            for(int i = 0; i < home.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chickens.size(); j++) {
                    if(visited[j]) { //i번째 집에서부터 j번짜 치킨집 까지의 거리 중 최소값을 구한다.
                        int dist = Math.abs(home.get(i).x - chickens.get(j).x)
                                + Math.abs(home.get(i).y - chickens.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for(int i = depth; i < chickens.size(); i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(count + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            M = Integer.parseInt(commands[1]);

            map = new int[N][N];
            home = new LinkedList<Node>();
            chickens = new LinkedList<Node>();

            for (int i = 0; i < N; i++) {
                String[] rows = br.readLine().split(" ");
                for (int j = 0; j < rows.length; j++) {
                    map[i][j] = Integer.parseInt(rows[j]);
                    if (map[i][j] == 1) {
                        // home 저장
                        home.add(new Node(i, j));
                    } else if (map[i][j] == 2) {
                        // chicken 저장
                        chickens.add(new Node(i, j));
                    }
                }
            }
            // 치킨집 방문 체크 배열
            visited = new boolean[chickens.size()];
            dfs(0, 0);
            System.out.println(min);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void sysout(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
