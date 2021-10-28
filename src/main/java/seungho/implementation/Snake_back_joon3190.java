package seungho.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.*;
        import java.util.*;

class Location {
    private final int row;
    private final int column;

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
public class Snake_back_joon3190 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        char[][] board = new char[N+1][N+1]; //주의

        HashMap<Integer,Character> move = new HashMap<>();
        Queue<Location> snake = new LinkedList<>();

        // 사과 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 'A';
        }
        // 방향 변환 정보
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            move.put(second,direction);
        }

        //board : A == 사과, S == 뱀
        int row = 1;
        int column = 1;
        char[] direction = {'L', 'B', 'R', 'T'};
        int dIdx = 0;
        snake.offer(new Location(row, column));
        for (int i = 1; i <= 10000; i++) {
            if (direction[dIdx % 4] == 'L') {
                column++;
            } else if (direction[dIdx % 4] == 'B') {
                row++;
            } else if (direction[dIdx % 4] == 'R') {
                column--;
            } else {
                row--;
            }
            checkLocation(row,column,board,N,i);

            // 뱀 머리 입력 및 사과가 존재하는지 체크
            snake.offer(new Location(row, column));
            if (board[row][column] == 0){
                Location tail = snake.poll();
                board[tail.getRow()][tail.getColumn()] = 0;
            }
            board[row][column] = 'S';

            // 위치변환 확인
            if (move.containsKey(i)){
                char d = move.get(i);
                if (d == 'D') dIdx ++;
                else{
                    if(dIdx == 0) dIdx = 4;
                    dIdx--;
                }
            }

        }

    }

    public static void checkLocation(int row, int column, char[][] board, int N, int idx){
        // 벽을 나가거나 자신의 몸에 부딪치면 게임종료
        if (row <= 0 || row > N || column <= 0 || column > N || board[row][column] == 'S') {
            System.out.println(idx);
            System.exit(0);
        }
    }


}