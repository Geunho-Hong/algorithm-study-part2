package sujung.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private boolean[][] dp;
    private List<String> subset;
    private List<List<String>> result;

    /**
     * 문자열 s의 모든 부분 팰린드롬 문자열을 반환한다.
     * DP를 통해 팰린드롬 판별 로직을 최적화하면 총 시간 복잡도는 O(N^2 + 2^N)
     * 그렇지 않은 경우 총 시간 복잡도는 O(N * 2^N)
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        // 팰린드롬 판별 최적화 O(N^2)
        int length = s.length();
        dp = new boolean[length][length];
        for (int window = 1; window <= length; window++) {
            for (int i = 0; i <= length - window; i++) {
                int j = i + window - 1;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        subset = new ArrayList<>();
        result = new ArrayList<>();
        go(0, s);
        return result;
    }

    /**
     * 문자열의 가능한 부분 집합을 모두 구해서 팰린드롬일 경우 subset에 추가한다.
     * 시간복잡도 O(2^N)
     * @param index
     * @param origin
     */
    private void go(int index, String origin) {
        if (index == origin.length()) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < origin.length(); i++) {
            if (dp[index][i]) {
                subset.add(origin.substring(index, i + 1));
                go(i + 1, origin);
                subset.remove(subset.size() - 1);
            }
        }
    }

    /**
     * 특정 구간의 문자열이 팰린드롬인지 판별한다.
     * 시간복잡도 O(N)
     * @param left
     * @param right
     * @param origin
     * @return
     */
    private boolean isPalindrome(int left, int right, String origin) {
        for (int i = 0; i <= (right - left) / 2; i++) {
            if (origin.charAt(left + i) != origin.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }
}
