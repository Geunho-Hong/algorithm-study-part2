package guenho.codility;

import java.util.Arrays;

public class MaxProductOfTrees {
    public static void main(String[] args) {
        //int[] A = {-3, 1, 2, -2, 5, 6};
        //int[] A = {-9,-5,-3,5,6};

        int[] A = {-5, 5, -5, 4};

        System.out.println(solution(A));
    }

    private static int solution(int[] A) {

        int answer = 0;

        Arrays.sort(A);

        answer = A[A.length-1]* A[A.length -2];
        answer = answer > 0 ? answer * A[A.length-3] : answer * A[0];

        return answer;
    }
}
