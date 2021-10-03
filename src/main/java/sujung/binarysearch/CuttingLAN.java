package sujung.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CuttingLAN {


    /**
     * K개의 랜선에서 N개의 랜선을 만들 수 있는 최대 길이는?
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = parseInt(st.nextToken());
            int N = parseInt(st.nextToken());
            int[] lines = new int[K];

            long max = 0;
            for (int i = 0; i < K; i++) {
                lines[i] = parseInt(br.readLine());
                max = Math.max(max, lines[i]);
            }

            long left = 0;
            long right = max + 1;
            while(left < right) {
                long mid = left + (right - left) / 2;
                if(feasible(mid, lines, N)) {   // N개 못만듦 = threshold 더 줄여야 함
                    right = mid;
                } else {
                    left = mid + 1;             // 최선인가? 오른쪽 더 탐색
                }
            }
            System.out.println(left - 1);
        }
    }

    private static boolean feasible(long threshold, int[] lines, int N) {
        int count = 0;
        for (int line : lines) {
            count += line / threshold;
        }
        return count < N;
    }
}
