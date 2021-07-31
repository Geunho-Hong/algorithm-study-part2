package guenho.exhuasive_search;

// https://www.acmicpc.net/problem/10819
// 최대를 구하라 -> 수열의 만들수 있는 경우의 수를 모두 구해서 최대 값을 구하자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maximum {

    private static int N,result;
    private static int[] arr, temp;
    private static boolean[] visited;

    private static void dfs(int depth) {
        if(depth == N) {
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(temp[i] - temp[i+1]);
            }
            result = Math.max(sum,result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] rows = br.readLine().split(" ");
        arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < rows.length; i++) {
            arr[i] = Integer.parseInt(rows[i]);
        }

        dfs(0);
        System.out.println(result);

    }
}
