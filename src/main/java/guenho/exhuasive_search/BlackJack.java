package guenho.exhuasive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BlackJack {

    private static int N, M;
    private static int[] cards;
    private static boolean[] visited;
    private static int[] arr;
    private static int max = 0;

    private static void dfs(int depth) {
        if(depth == N) {
            diff();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = cards[i]; // i -> depth
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            result += arr[i];
        }

        if(result > M) {
            return;
        }

        max = Math.max(result , max);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] commands = br.readLine().split(" ");

            N = Integer.parseInt(commands[0]);
            M = Integer.parseInt(commands[1]);

            cards = new int[N];
            arr = new int[N];
            visited = new boolean[N];

            String[] rows = br.readLine().split(" ");

            for (int i = 0; i < rows.length; i++) {
                cards[i] = Integer.parseInt(rows[i]);
            }

            dfs(0);

            System.out.println(max);
        }
    }
}
