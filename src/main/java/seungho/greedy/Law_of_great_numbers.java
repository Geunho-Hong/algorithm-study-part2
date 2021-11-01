package seungho.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Law_of_great_numbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] nums = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, Collections.reverseOrder());
        int first = nums[0];
        int second = nums[1];

        int answer = 0;
        int cnt = (m / k + 1) * k + m % (k + 1);
        answer += first * cnt;
        answer += second * (m - cnt);
        System.out.println(answer);
    }

}
