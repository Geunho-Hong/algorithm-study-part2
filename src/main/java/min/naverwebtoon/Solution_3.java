package min.naverwebtoon;

public class Solution_3 {

    static int result = 0;

    public static void main(String[] args) {
        int solution = solution("aabcbcd", "abc");
        System.out.println("solution = " + solution);
    }

    public static int solution(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        int tStartIndex = sb.indexOf(t);

        if (tStartIndex < 0) return 0;

        int tEndIndex = tStartIndex + t.length();
        sb.delete(tStartIndex, tEndIndex);

        result++;

        solution(sb.toString(), t);

        return result;
    }

}
