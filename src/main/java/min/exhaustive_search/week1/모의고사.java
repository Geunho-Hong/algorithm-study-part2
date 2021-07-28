package min.exhaustive_search.week1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 모의고사 {

    public static void main(String[] args) {
        int[] answer = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answer)));
    }

    public static int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] giverAnswers = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (pattern1[i % pattern1.length] == answers[i]) giverAnswers[0]++;
            if (pattern2[i % pattern2.length] == answers[i]) giverAnswers[1]++;
            if (pattern3[i % pattern3.length] == answers[i]) giverAnswers[2]++;
        }

        int max = Arrays.stream(giverAnswers).max().getAsInt();

        return IntStream.range(0, giverAnswers.length)
                .filter(i -> giverAnswers[i] == max)
                .map(i -> i + 1)
                .toArray();
    }

}
