package guenho.strings;

// https://leetcode.com/problems/longest-palindromic-substring/
// Palindromic : 앞 뒤가 대칭인 문자열

public class LongestSubString {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            temp = searchCenterBy(s, i, i);

            if (temp.length() > longest.length()) {
                longest = temp;
            }
            temp = searchCenterBy(s, i, i + 1);

            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        return longest;
    }

    private static String searchCenterBy(String s, int curLeft, int curRight) {
        String result = "";

        /**
         * Loop Palindromic
         */

        while (curLeft >= 0 && curRight < s.length() && s.charAt(curLeft) == s.charAt(curRight)) {
            curLeft--;
            curRight++;
        }
        return s.substring(curLeft + 1, curRight);
    }

}
