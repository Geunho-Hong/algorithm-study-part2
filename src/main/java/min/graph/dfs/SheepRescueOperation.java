package min.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SheepRescueOperation {

    static int n;

    static int[] sheepAmounts;
    static List<Integer>[] edgeList;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(dfs(1));
    }

    static long dfs(int no) {
        if (edgeList[no].isEmpty())
            return Math.max(sheepAmounts[no], 0);

        long sumAmount = sheepAmounts[no];
        for (int next : edgeList[no]) {
            sumAmount += dfs(next);
        }

        return Math.max(sumAmount, 0L);
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());

            sheepAmounts = new int[n + 1];
            edgeList = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                edgeList[i] = new ArrayList<>();
            }

            for (int i = 2; i <= n; i++) {
                String[] strArr = br.readLine().split(" ");

                String type = strArr[0];
                int sheepAmount = Integer.parseInt(strArr[1]);
                int p = Integer.parseInt(strArr[2]);

                sheepAmounts[i] = type.equals("S") ? sheepAmount : -sheepAmount;
                edgeList[p].add(i);
            }
        }
    }
}