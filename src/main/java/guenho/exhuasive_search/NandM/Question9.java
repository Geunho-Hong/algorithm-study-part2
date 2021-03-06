package guenho.exhuasive_search.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

// StringBuilder를 사용하면 생각보다 시간이 많이 걸릴수 있다.

public class Question9 {

    private static int N, M;
    private static int[] arr;
    private static int[] columnArr;
    private static boolean[] visited;
    private static LinkedHashSet<String> set = new LinkedHashSet<>();
    private static StringBuilder sb ;

    private static void dfs(int depth) {
        if(depth == M) {
            sb = new StringBuilder();
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            set.add(sb.toString());
            return ;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = columnArr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        arr = new int[M];
        columnArr = new int[N];
        visited = new boolean[N];

        String[] rows = br.readLine().split(" ");

        for (int i = 0; i < rows.length; i++) {
            columnArr[i] = Integer.parseInt(rows[i]);
        }

        Arrays.sort(columnArr);

        dfs(0);

        for(String s : set) {
            System.out.print(s);
            System.out.println();
        }

    }
}
