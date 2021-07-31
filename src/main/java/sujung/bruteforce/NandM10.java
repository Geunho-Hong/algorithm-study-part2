package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM10 {
    private static int N, M;
    private static int[] origin, answer;
    private static StringBuilder sb;
    private static Set<String> set;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            origin = new int[N];
            answer = new int[M];

            set = new HashSet<>();
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                origin[i] = parseInt(st.nextToken());
            }
            Arrays.sort(origin);
            go(0, 0);
            System.out.println(sb);
        }
    }

    /**
     * N개의 자연수 중에서 M개를 고른 수열
     * 고른 수열은 비내림차순이어야 한다.
     * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     * @param index
     * @param start
     */
    private static void go(int index, int start) {
        if (index >= M) {
            StringBuilder temp = new StringBuilder();
            for (int x : answer) {
                temp.append(x).append(" ");
            }
            if (!set.contains(temp.toString())) {
                set.add(temp.toString());
                sb.append(temp).append("\n");
            }
            return;
        }
        for (int i = start; i < N; i++) {
            answer[index] = origin[i];
            go(index + 1, i + 1);
        }
    }
}
