package sujung.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class MakeNumberToOne {

    /**
     * 연산 종류
     * 1. 3으로 나눈다.
     * 2. 2로 나누다.
     * 3. 1로 뺀다.
     * dp[i] = i를 만드는 최소 연산 횟수
     * dp[i] = min(dp[i+1], dp[i*2], dp[i*3]) + 1
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int num = parseInt(br.readLine());

            int[] dp = new int[num + 1];
            dp[num] = 0;
            dp[num - 1] = 1;
            for (int i = dp.length - 2; i >= 1; i--) {
                int temp = Integer.MAX_VALUE;
                if(i + 1 <= num) {
                    temp = Math.min(temp, dp[i + 1]);
                }
                if(i * 2 <= num) {
                    temp = Math.min(temp, dp[i * 2]);
                }
                if(i * 3 <= num) {
                    temp = Math.min(temp, dp[i * 3]);
                }
                dp[i] = temp + 1;
            }
            System.out.println(dp[1]);
        }
    }
}
