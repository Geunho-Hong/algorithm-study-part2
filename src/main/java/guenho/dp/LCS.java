package guenho.dp;

// https://www.acmicpc.net/problem/9251
// https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String firstStr = br.readLine();
            String secondStr = br.readLine();

            /**
             * 문자열이 같을때 = dp[i-1][j-1] + 1
             * 문자열이 다를때 = Math.max(dp[i][j-1], dp[i-1][j])
             */
            
            dp = new int[firstStr.length()+1][secondStr.length()+1];

            for (int i = 1; i <= firstStr.length(); i++) {
                for (int j = 1; j <= secondStr.length(); j++) {
                    if(firstStr.charAt(i-1) == secondStr.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }

            System.out.println(dp[firstStr.length()][secondStr.length()]);
        }
    }
}
