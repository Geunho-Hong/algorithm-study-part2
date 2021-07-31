package sujung.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class MaximumDifference {
    private static int[] origin;
    private static boolean[] used;
    private static int[] result;
    private static int max;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int N = Integer.parseInt(br.readLine());
            max = 0;
            origin = new int[N];
            result = new int[N];
            used = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                origin[i] = Integer.parseInt(st.nextToken());
            }

            permutation(0);
            System.out.println(max);
        }
    }

    private static void permutation(int index) {
        if (index >= origin.length) {
            int sum = 0;
            for (int i = 0; i < origin.length - 1; i++) {
                int temp = result[i] - result[i + 1];
                if (temp < 0) temp *= -1;
                sum += temp;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < origin.length; i++) {
            if (used[i]) continue;
            result[index] = origin[i];
            used[i] = true;
            permutation(index + 1);
            used[i] = false;
        }
    }
}
