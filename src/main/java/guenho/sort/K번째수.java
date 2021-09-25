package guenho.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K번째수 {

    private static int[] inArr;

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(array,commands);

        for(int num : answer ){
            System.out.println("num = " + num);
        }

    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for (int idx = 0; idx < commands.length; idx++) {

            int i = commands[idx][0]-1;
            int j = commands[idx][1]-1;
            int k = commands[idx][2]-1;

            inArr = new int[(j-i) + 1];

            int pIdx = 0;

            for (int p = i; p <= j; p++) {
                inArr[pIdx++] = array[p];
            }

            Arrays.sort(inArr);
            list.add(inArr[k]);
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}