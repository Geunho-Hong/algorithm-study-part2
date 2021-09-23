package guenho.programmers_practice;

public class NumberStringAndWordsSolve {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for (int i = 0; i < digits.length; i++) {
             s = s.replaceAll(alphabets[i],digits[i]);
        }
        return Integer.parseInt(s);
    }
}
