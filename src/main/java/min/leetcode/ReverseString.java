package min.leetcode;

public class ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

    public static void reverseString(char[] s) {
        int p1 = 0;
        int p2 = s.length - 1;

        int n = s.length / 2;
        for (int i = 0; i < n; i++) {
            char temp = s[p1];
            s[p1++] = s[p2];
            s[p2--] = temp;
        }
    }
}
