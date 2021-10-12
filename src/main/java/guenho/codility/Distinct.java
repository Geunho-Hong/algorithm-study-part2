package guenho.codility;

import java.util.*;

public class Distinct {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(arr));
    }

    private static int solution(int[] A) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        return set.size();
    }
}
