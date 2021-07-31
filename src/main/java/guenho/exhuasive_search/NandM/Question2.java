package guenho.exhuasive_search.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://st-lab.tistory.com/115

public class Question2 {

    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;

    private static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 1; i < arr.length; i++) {
                if(arr[i-1] > arr[i]) {
                    return;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N,M,depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        arr = new int[M]; // 출력 결과를 담는 배열
        visited = new boolean[N];   // 방문 여부를 체크하기 위한 배열

        dfs(N,M,0);
    }
}
