package guenho.programmers_practice;

public class Question3 {
    public static void main(String[] args) {
        System.out.println(solution(5,3));
    }

    public static long solution(int a, int b) {
        long answer = 0;
        if (a == b) {
            return a;
        }
        int start = Math.min(a, b);
        int last = Math.max(a, b);

        for (int i = start; i <= last; i++) {
            answer += i;
        }
        return answer;
    }

}
