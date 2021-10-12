package guenho.codility;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[] A = {10,2,5,1,8,20};
        //int[] A = {10,50,5,1};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        // P < Q < R < N
        // 1,2,5,8,10,20
        // 두 수를 더 한 값은 나머지 한 개 보다 크다

        boolean isTriangle = false;
        Arrays.sort(A);

        for (int i = A.length -3 ; i >= 0; i--) {

            long pNum = A[i+2];
            long qNum = A[i+1];
            long rNum = A[i];

            if( (pNum + qNum > rNum ) && (qNum + rNum) > pNum && (pNum + rNum) > qNum ) {
                isTriangle = true;
                break;
            }
        }

        return isTriangle ? 1 : 0;
    }
}
