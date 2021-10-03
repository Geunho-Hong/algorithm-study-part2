package sujung.sort;

import java.util.Arrays;

public class KthNumber {

    /**
     * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수
     * @param array
     * @param commands
     * @return
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int size = 0;
        for (int[] command : commands) {
            int[] temp = Arrays.copyOf(array, array.length);
            Arrays.sort(temp, command[0] - 1, command[1]);

            answer[size] = temp[command[0] - 1 + command[2] - 1];
            size++;
        }
        return answer;
    }
}
