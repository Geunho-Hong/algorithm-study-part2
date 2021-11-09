package seungho.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number_card_game {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                // 현재 줄에서 '가장 작은 수' 찾기
                int x = Integer.parseInt(st.nextToken());
                min_value = Math.min(x, min_value);
            }
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }
}
