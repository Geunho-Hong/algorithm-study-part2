package guenho.codility;

// https://darkstart.tistory.com/195

import java.util.Arrays;

public class NumberOfDistIntersection {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 1, 4, 0};
        System.out.println(solution(arr));
    }

    private static int solution(int[] A) {

        long[] start = new long[A.length];
        long[] end = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            start[i] = i - (long)A[i];
            end[i] = i + (long)A[i];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int intersection = 0;
        int cur = 0;

        for (int i = 0; i < A.length; i++) {
            while( cur < A.length && end[i] >= start[cur]) {
                intersection += cur;
                intersection -= i;
                cur++;
            }
        }

        return intersection > 10_000_000 ? -1 : intersection;
    }
}
