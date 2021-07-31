package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM3 {
    private static int[] sequence;
    private static int N, M;
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            answer = new StringBuilder();
            sequence = new int[M];
            go(0);
            System.out.println(answer);
        }
    }

    /**
     * 1부터 N까지 자연수 중에서 M개를 고른 수열 (중복 허용)
     * @param index
     */
    private static void go(int index) {
        if (index >= M) {
            for (int i = 0; i < M; i++) {
                answer.append(sequence[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            sequence[index] = i;
            go(index + 1);
        }
    }
}
