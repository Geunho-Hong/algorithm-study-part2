package min.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BabyShark_Solution {

    static int n; // 수족관 크기 n * n

    static BabyShark babyShark;
    static int[][] aquarium;

    static int[] bx = {-1, 1, 0, 0}; // 상하
    static int[] by = {0, 0, -1, 1}; // 좌우

    // 거리가 가장 가까운 물고기 먹기
    static boolean bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(babyShark.x, babyShark.y, 0));

        // 물고기를 한번 찾았더라도 다음 물고기를 찾아야하므로 방문 기록을 초기화 되어야함
        boolean[][] visited = new boolean[n][n];
        visited[babyShark.x][babyShark.y] = true;

        // 먹을 수 있는 물고기의 최단 거리
        // 물고기의 최단 거리를 구해야하기 때문에 최장 거리인 400 보다 큰 값으로 초기화
        int minDistance = 401;
        int minX = -1;
        int minY = -1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = current.x + bx[k];
                int ny = current.y + by[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (visited[nx][ny] || !babyShark.isMove(aquarium[nx][ny]))
                    continue;

                // 먹을 수 있는 물고기의 위치와 거리를 계산한다.
                queue.offer(new Point(nx, ny, current.distance + 1));
                visited[nx][ny] = true;

                if (babyShark.isEatFish(aquarium[nx][ny])) {
                    // 아기 상어와 먹을 수 있는 물고기의 거리
                    int fishDistance = current.distance + 1;

                    if (minDistance > fishDistance) { // 최단 거리 물고기로 위치 갱신
                        minDistance = fishDistance;
                        minX = nx;
                        minY = ny;
                    } else if (minDistance == fishDistance) { // 같은 최단 거리 물고기가 나오면
                        if (nx < minX) { // 가장 위의 물고기
                            minX = nx;
                            minY = ny;
                        } else if (nx == minX) { // 높이가 같으면 가장 왼쪽
                            if (ny < minY)
                                minY = ny;
                        }
                    }
                }
            }
        }

        if (minX == -1) // 먹을 수 있는 물고기가 없으면 종료
            return true;

        // 수족관 내에서 물고기가 있던 자리로 상어 이동
        aquarium[minX][minY] = 9;
        // 원래 상어가 있던 자리 빈공간으로 변경
        aquarium[babyShark.x][babyShark.y] = 0;
        // 경험치 쌓기
        babyShark.eatFish();
        // 이동 (시간 축적 시키기)
        babyShark.move(minDistance, minX, minY);

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        aquarium = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aquarium[i][j] = scanner.nextInt();

                // 아기상어 생성
                if (aquarium[i][j] == 9)
                    babyShark = new BabyShark(i, j);
            }
        }

        while (true)
            if (bfs()) break;

        System.out.println(babyShark.moveTime);
    }

    ///////// Class /////////

    static class BabyShark {
        int x; // 상어 위치 x
        int y; // 상어 위치 y

        int size; // 상어 크기
        int eatFishSize; // 상어 경험치

        int moveTime; // 상어의 이동 시간

        public BabyShark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
        }

        // 아기 상어는 자신의 크기와 같거나 작은 곳만 이동할 수 있음
        public boolean isMove(int fishSize) {
            return this.size >= fishSize;
        }

        // 아기 상어 이동 시 1초가 걸린다.
        public void move(int distance, int x, int y) {
            this.moveTime += distance;
            this.x = x;
            this.y = y;
        }

        // 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있음
        public boolean isEatFish(int fishSize) {
            // 빈공간은 먹을 수 없음
            return fishSize != 0 && this.size > fishSize;
        }

        // 아기 상어는 물고기를 자신의 몸 크기만큼 먹어야 크기가 1 증가됨
        public void eatFish() {
            eatFishSize++;
            if (size <= eatFishSize) {
                eatFishSize -= size;
                size++;
            }
        }
    }

    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}