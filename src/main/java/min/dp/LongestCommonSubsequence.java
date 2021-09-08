package min.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "ABCDEF"; // i
        String s2 = "GBCDFE"; // j

        int length = s1.length();
        int[][] LCS = new int[length + 1][length + 1];

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                char c1 = s1.charAt(i  -1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2)
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                else
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
            }
            System.out.println(Arrays.toString(LCS[i]));
        }

    }


}
