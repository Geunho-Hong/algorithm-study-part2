package guenho.codility;


// Easy한 문제이다 but 너무 꼬아서 생각했다.
public class TieRopes {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(solution(4, A));
    }

    private static int solution(int K, int[] A) {

        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            int rope = A[i];
            sum += rope;

            if(sum >= K) {
                cnt ++;
                sum = 0;
            }
        }

        return cnt;
    }

}
