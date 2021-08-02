package min.exhaustive_search.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 차이를_최대로 {

    static int n;
    static int[] A;
    static int maxSum;

    public static void main(String[] args) throws IOException {
        init();
        permutation(0);
        System.out.println(maxSum);
    }

    static void permutation(int k) {
        if (k == n) {
            maxSum = Math.max(maxSum, calculate());
            return;
        }

        for (int i = k; i < n; i++) {
            swap(k, i);
            permutation(k + 1);
            swap(k, i);
        }
    }

    static int calculate() {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.abs(A[i - 1] - A[i]);
        }
        return sum;
    }

    static void swap(int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            A = new int[n];

            String[] strArr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(strArr[i]);
            }
        }
    }
}
