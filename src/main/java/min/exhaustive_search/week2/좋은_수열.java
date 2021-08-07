package min.exhaustive_search.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은_수열 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == n) {
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            if (isGoodSequence())
                dfs(depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean isGoodSequence() {
        if (sb.length() < 2) return true;

        int length = sb.length();
        for (int i = 1; i <= length / 2; i++) {
            String first = sb.substring(length - i - i, length - i);
            String second = sb.substring(length - i, length);

            if (first.equals(second))
                return false;
        }

        return true;
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
        }
    }

}
