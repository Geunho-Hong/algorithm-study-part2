package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM2 {
    private static int N, M;
    private static int[] sequence;
    private static boolean[] used;
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            sequence = new int[M];
            used = new boolean[N + 1];
            answer = new StringBuilder();

            go(1, 0);
            System.out.println(answer);
        }
    }

    /**
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (오름차순)
     * @param start
     * @param index
     */
    private static void go(int start, int index) {
        if (index >= M) {
            for (int x : sequence) {
                answer.append(x).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                sequence[index] = i;
                go(i + 1, index + 1);
                used[i] = false;
            }
        }
    }
}
