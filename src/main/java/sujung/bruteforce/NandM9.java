package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NandM9 {
    private static int N, M;
    private static int[] origin, answer;
    private static int[] count;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            origin = new int[N];
            answer = new int[M];
            count = new int[10001];
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[N];
            int k = 0;
            for (int i = 0; i < N; i++) {
                temp[i] = parseInt(st.nextToken());
            }
            Arrays.sort(temp);
            for (int i = 0; i < N; i++) {
                count[temp[i]]++;
                if (count[temp[i]] == 1) {
                    origin[k] = temp[i];
                    k++;
                }
            }
            go(0);
            System.out.println(sb);
        }
    }

    /**
     * N개의 자연수 중에서 M개를 고른 수열
     * @param index
     */
    private static void go(int index) {
        if (index >= M) {
            for (int x : answer) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (count[origin[i]] > 0) {
                count[origin[i]] -= 1;
                answer[index] = origin[i];
                go(index + 1);
                count[origin[i]] += 1;
            }
        }
    }
}
