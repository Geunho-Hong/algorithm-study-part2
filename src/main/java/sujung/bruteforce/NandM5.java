package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM5 {

    private static int N, M;
    private static int[] origin, answer;
    private static boolean[] used;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            origin = new int[N];
            used = new boolean[N];
            answer = new int[M];
            result = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                origin[i] = parseInt(st.nextToken());
            }
            Arrays.sort(origin);
            go(0);
            System.out.println(result);
        }
    }

    /**
     * N개의 자연수 중에서 M개를 고른 수열, 모두 다른 수
     * @param index
     */
    private static void go(int index) {
        if (index >= M) {
            for (int x : answer) {
                result.append(x).append(" ");
            }
            result.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            answer[index] = origin[i];
            go(index + 1);
            used[i] = false;
        }
    }
}
