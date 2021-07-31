package sujung.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class MockTest {
    public int[] solution(int[] answers) {
        int size = answers.length;
        int[] scores = new int[3];

        List<Integer> answer = new ArrayList<>();

        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < size; i++) {
            if (answers[i] == first[i % 5]) scores[0]++;
            if (answers[i] == second[i % 8]) scores[1]++;
            if (answers[i] == third[i % 10]) scores[2]++;
        }

        int max = Math.max(Math.max(scores[0], scores[1]), scores[2]);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
