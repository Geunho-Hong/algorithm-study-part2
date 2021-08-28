package sujung.string;

public class LongestPalindromicSubstring {

    /**
     * Get Longest Palindromic Substring
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();

        String result = "";

        // dp[i][j] : 인덱스 i부터 j까지의 부분 문자열이 팰린드롬인지 여부
        boolean[][] dp = new boolean[length][length];

        for (int window = 1; window <= length; window++) {
            for (int i = 0; i <= length - window; i++) {
                int j = i + window - 1;

                // 팰린드롬이 형성될 수 있는 조건 ..
                // 새로 추가되는 양쪽의 문자가 같으면서 이전의 문자열이 팰린드롬이어야 함
                // 새로 추가되는 양쪽의 문자가 같은데 그게 1자리 또는 2자리 문자열이어야 함
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && result.length() < j - i + 1) {  // 갱신
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}
