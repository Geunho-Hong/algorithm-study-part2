package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM6 {
    private static int N, M;
    private static int[] origin, answer;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            origin = new int[N];
            answer = new int[M];
            result = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                origin[i] = parseInt(st.nextToken());
            }
            Arrays.sort(origin);
            go(0, 0);
            System.out.println(result);
        }
    }

    /**
     * N개의 자연수 중에서 M개를 고른 수열. 모두 다른 수
     * 고른 수열은 오름차순이어야 한다.
     *
     * @param index
     * @param selected
     */
    private static void go(int index, int selected) {
        if (selected >= M) {
            for (int x : answer) {
                result.append(x).append(" ");
            }
            result.append("\n");
            return;
        }
        if (index >= N) return;
        for (int i = index; i < N; i++) {
            answer[selected] = origin[i];
            go(i + 1, selected + 1);
        }
    }
}
