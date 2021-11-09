package seungho.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Util_it_reach_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        while (true) {
            int target = n % k;
            count += target;
            n -= target;

            if (n < k) break;
            n /= k;
            count++;
        }
        // 현재 n값 0
        System.out.println(--count);

    }
}
