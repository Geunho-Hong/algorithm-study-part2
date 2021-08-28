package min.string.week2;

public class LongestPalindromicSubstring {

    int resultStartIdx;
    int maxLength;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);  // 홀수
            extendPalindrome(s, i, i + 1); // 짝수
        }

        return s.substring(resultStartIdx, resultStartIdx + maxLength);
    }

    private void extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length()
                && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        if (maxLength < end - start - 1) {
            resultStartIdx = start + 1; // 위에서 start 를 - 1 해주었기 때문에 다시 증가시킴
            maxLength = end - start - 1; // end는 1 증가, start는 1 감소된 상태이기 때문에 -1 을 해줘야 회문의 길이가 나옴
        }
    }
}
