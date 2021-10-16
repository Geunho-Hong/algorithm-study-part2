package guenho.codility;

public class MaxNonOverLappingSegments {
    public static void main(String[] args) {
        int[] A = {1,3,7,9,9};
        int[] B = {5,6,8,9,10};

        solution(A,B);
    }

    private static int solution(int[] A, int[] B){

        if(A.length <= 1) {
            return A.length;
        }

        int cnt = 1;
        int endPoint = B[0];

        for (int i = 1; i < A.length; i++) {

            int curStart = A[i];

            if(curStart > endPoint) {
                endPoint = B[i];
                cnt ++;
            }
        }
        return cnt;
    }
}
