package guenho.strings;

// https://leetcode.com/problems/palindrome-partitioning/
// https://gracefulsoul.github.io/leetcode/palindrome-partitioning/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String s = "aab";
        System.out.println(partition(s));
    }


    private static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        ArrayList<String> partition = new ArrayList<String>();
        addPalindrome(s, 0, partition, result);

        return result;
    }

    private static void addPalindrome(String s, int index, ArrayList<String> partition,
                                      List<List<String>> result) {

        // base case
        if (index == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s,index,i)) {
                partition.add(s.substring(index,i+1));
                addPalindrome(s, i+1, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    /*private static void selectPartition(String s, int curLeft, int curRight) {

        if (curLeft < 0 || curRight >= s.length()) {
            return;
        }

        if (s.charAt(curLeft) == s.charAt(curRight)) {
            String temp = s.substring(curLeft, curRight + 1);
            partitionLst.add(temp);
            selectPartition(s, curLeft - 1, curRight + 1);
        }
    }*/

}