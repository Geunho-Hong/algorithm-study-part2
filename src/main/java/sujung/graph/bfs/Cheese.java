package sujung.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Cheeze {

    private static int N, M;
    private static int[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            initMap(br);

            // 치즈가 다 없어지는 시간은?
            // 1인데 상하좌우에 0이 두개이상인 놈을 큐에 담는다
            // 갇혀있는 빈 공간은 0으로 채우지 않는다.
            // 방문했으면 2

            // 큐에 있는 놈을 돌리면서
            // 근접한 1인 애의 상하좌우가 0이 2개 이상이면
            // 큐애 넣는다.


        }
    }

    private static void initMap(BufferedReader br) throws IOException {
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                // count cheeze cell
                if(map[i][j] == 1) {
                    
                }
            }
        }
    }

    private static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
