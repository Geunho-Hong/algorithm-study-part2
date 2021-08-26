package min.string.week2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> results = new PalindromePartitioning().partition("aab");
    }

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> subResult = new ArrayList<>();

        dfs(s, 0, results, subResult);

        return results;
    }

    private void dfs(String s, int depth, List<List<String>> results, List<String> subResult) {
        if (depth == s.length()) {
            results.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = depth; i < s.length(); i++) {
            // 0 3
            if (isPalindrome(s, depth, i)) {
                subResult.add(s.substring(depth, i + 1));
                dfs(s, i + 1, results, subResult);
                subResult.remove(subResult.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        // a b c b
        // 0 1 2 3
        while (end > start)
            if (s.charAt(start++) != s.charAt(end--))
                return false;

        return true;
    }

}
