package guenho.exhuasive_search.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question4 {

    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    /**
     * 이 방법이 아니라 cur 방식으로 재 풀이 해보기
     */
    private static void dfs(int N, int M, int depth) {
        if (M == depth) {
            for (int i = 1; i <= arr.length-1; i++) {
                if(arr[i-1] > arr[i]) {
                    return;
                }
            }
            for (int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        arr = new int[M];
        dfs(N, M, 0);
        System.out.print(sb.toString());

    }
}
