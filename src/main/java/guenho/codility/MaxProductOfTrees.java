package guenho.codility;

import java.util.Arrays;

public class MaxProductOfTrees {
    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6};
        //int[] A = {-9,-5,-3,5,6};

        //int[] A = {-5, 5, -5, 4};

        System.out.println(solution(A));
    }

    private static int solution(int[] A) {

        /**
         * 가장 큰 수 가 나오는 경우
         * 1. 양 * 양 * 양
         * 2. 양 * 음 *음
         */

        Arrays.sort(A);

        int number1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int number2 = A[A.length - 1] * A[0] * A[1];

        return number1 > number2 ? number1 : number2;
    }
}
