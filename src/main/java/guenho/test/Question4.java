package guenho.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question4 {

    public static void main(String[] args) {
        int[][] info = {{1,5},{3,5},{7,8}};
        int[] answer = solution(info);

        for(int num : answer) {
            System.out.println("num = " + num);
        }

    }

    private static int[] solution(int[][] info ){

        List<Integer> answerList = new ArrayList<>();
        int[] cntArr = new int[10];

        for (int i = 0; i < info.length; i++) {
            int startTime = info[i][0];
            int endTime = info[i][1];
            for (int j = startTime; j <= endTime; j++) {
                cntArr[j]++;
            }
        }

        int maxNumber = Arrays.stream(cntArr).max().getAsInt();

        for (int i = 1; i < cntArr.length; i++) {
            if(maxNumber <= cntArr[i]) {
                answerList.add(i);
            }
        }

        int[] answer = {};
        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}