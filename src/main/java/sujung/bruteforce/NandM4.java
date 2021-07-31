package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM4 {

    private static int[] sequence;
    private static int N, M;
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            sequence = new int[M];
            answer = new StringBuilder();

            go(1, 0);
            System.out.println(answer);
        }
    }

    /**
     * 1부터 N까지 자연수 중에서 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     * 고른 수열은 비내림차순이어야 한다.
     * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     * @param start
     * @param index
     */
    private static void go(int start, int index) {
        if (index >= M) {
            for (int x : sequence)
                answer.append(x).append(" ");
            answer.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            sequence[index] = i;
            go(i, index + 1);
        }
    }
}
