package min.exhaustive_search.week1;

import java.util.Arrays;

public class 카펫 {

    public static void main(String[] args) {
        카펫 카펫 = new 카펫();
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(카펫.solution(brown, yellow)));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        int height = 3;
        while (true) {
            int width = sum / height;
            if ((height - 2) * (width - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
            height++;
        }

        return answer;
    }

}
