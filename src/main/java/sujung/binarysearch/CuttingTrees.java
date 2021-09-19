package sujung.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CuttingTrees {

    private static int N, M;
    private static int[] trees;

    /**
     * N개의 나무들의 높이가 주어질 때, M미터를 가져가기 위해 절단해야 하는 최대 높이값은?
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            trees = new int[N];
            int max = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                trees[i] = parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }

            int result = binarySearch(max);
            System.out.println(result);
        }
    }

    private static int binarySearch(int val) {
        int left = 0;
        int right = val;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (compute(mid) >= M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private static long compute(int length) {
        long temp = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > length) {
                temp += (trees[i] - length);
            }
        }
        return temp;
    }
}
