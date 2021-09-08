package min.dp.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Blog: https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
public class LCS {

    // LCS의 두 가지 의미
    // 1. Longest Common Subsequence: 최장 공통 부분수열
    // 2. Longest Common Substring: 최장 공통 부분문자열
    static int[][] LCS;

    static String s1, s2;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2)
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                else
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
            }
        }

        System.out.println(LCS[s1.length()][s2.length()]);
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            s1 = br.readLine();
            s2 = br.readLine();

            LCS = new int[s1.length() + 1][s2.length() + 1];
        }
    }

}