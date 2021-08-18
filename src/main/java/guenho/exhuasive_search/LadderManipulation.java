package guenho.exhuasive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://h-kyung.tistory.com/16

public class LadderManipulation {

    private static int N,M,H,answer;
    private static int[][] map;
    private static boolean isFinish = false;

    private static boolean isCheck(){
        for (int i = 1; i <= N; i++) {
            int nX = 1;
            int nY = i;
            for (int j = 0; j < H; j++) {
                if(map[nX][nY] == 1) {
                    nY++;
                } else if(map[nX][nY] == 2) {
                    nY--;
                }
                nX++;
            }
            if(nY != i) {
                return  false;
            }
        }
        return true;
    }

    private static void dfs(int x , int depth) {
        if(isFinish) {
            return;
        }

        if(answer == depth) {
            if(isCheck()) {
                isFinish = true;
                return;
            }
        }
        for (int i = x; i < H + 1; i++) {
            for (int j = 1; j < N; j++) {
                // 양 옆이 0일때 선 긋기
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    // 재귀
                    dfs(i, depth + 1);
                    // 재귀후 다시 원래 값으로 초기화
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            M = Integer.parseInt(commands[1]);
            H = Integer.parseInt(commands[2]);

            map = new int[H+1][N+1];

            for (int i = 0; i < M; i++) {
                String[] ladders = br.readLine().split(" ");
                int x = Integer.parseInt(ladders[0]);
                int y = Integer.parseInt(ladders[1]);

                // 1이면 오른쪽 한 칸 이동
                map[x][y] = 1;
                // 2면 왼쪽 한칸 이동
                map[x][y+1] = 2;
            }

            for (int i = 0; i <= 3; i++) {

                answer = i;
                dfs(1,0);

                if(isFinish) {
                    break;
                }
            }

            System.out.println((isFinish ? answer : -1));

        }
    }
}
