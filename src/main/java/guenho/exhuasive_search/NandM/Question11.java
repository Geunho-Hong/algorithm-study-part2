package guenho.exhuasive_search.NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question11 {

    private static int N, M;
    private static int[] arr;
    private static int[] columnArr;
   // private static LinkedHashSet<String> set = new LinkedHashSet<String>();

    private static void dfs(int depth, StringBuilder sb) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            //set.add(sb.toString());
            return;
        }

        int preValue = -999;

        for (int i = 0; i < N; i++) {
            if(preValue == columnArr[i]) {
                continue;
            }
            arr[depth] = columnArr[i];
            preValue = columnArr[i];

            dfs(depth + 1, sb);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split(" ");

        N = Integer.parseInt(commands[0]);
        M = Integer.parseInt(commands[1]);

        arr = new int[M];
        columnArr = new int[N];

        String[] rows = br.readLine().split(" ");

        for (int i = 0; i < rows.length; i++) {
            columnArr[i] = Integer.parseInt(rows[i]);
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(columnArr);
        dfs(0, sb);
        System.out.print(sb.toString());

        /*for (String s : set) {
            System.out.print(s);
        }*/
    }
}
