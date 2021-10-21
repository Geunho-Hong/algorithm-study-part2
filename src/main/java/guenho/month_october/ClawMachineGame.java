package guenho.month_october;

import java.util.Stack;

public class ClawMachineGame {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    /**
     * 순서를 따지며 같은 개수가 몇번 나왔는지 Count 하기
     * Stack(LIFO) 을 활용해서 풀어야 한다
     * -> 꺼내는 순간 당겨주는 구조
     */

    /**
     * 헤멘 이유
     * 1. 문제를 잘 못 파악해서 빼서 달라붙는 경우를 탐색 고려하지 못함
     * 2. 문제를 잘 못 읽어 행,열 구조의 인덱스를 다르게 해서 가져옴
     */

    private static int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int doll = board[j][moves[i] - 1];
                if (doll != 0) {
                    /**
                     * 2개가 같아지는 순간 꺼낸다
                     */
                    if (stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
