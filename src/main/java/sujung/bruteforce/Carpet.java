package sujung.bruteforce;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;
        int height = 3;
        int width = 2000000;

        while (height <= width) {
            if (total % height == 0) {
                width = total / height;
                if ((height - 2) * (width - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    return answer;
                }
            }
            height++;
        }
        return answer;
    }
}