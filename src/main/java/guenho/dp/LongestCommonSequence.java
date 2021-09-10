package guenho.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최장 증가 부분 수열
// https://jonyo.tistory.com/44

public class LongestCommonSequence {

    private static int N,result;
    private static int[] arr,dp;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            dp = new int[N + 1];

            String[] lines = br.readLine().split(" ");

            for (int i = 0; i < lines.length; i++) {
                arr[i] = Integer.parseInt(lines[i]);
            }

            for (int i = 0; i < N; i++) {
                // 큰 수가 없다면 dp[i] -> 1로 초기화
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    // 큰 수가 있다면 dp[i] -> Math.max(dp[i],dp[j+1])
                    if(arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                result = Math.max(result,dp[i]);
            }
            System.out.println(result);
        }
    }
}
