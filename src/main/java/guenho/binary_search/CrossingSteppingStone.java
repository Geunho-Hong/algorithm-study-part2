package guenho.binary_search;

// https://minhamina.tistory.com/129
public class CrossingSteppingStone {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int answer = solution(stones, k);
        System.out.println(answer);
    }

    private static int solution(int[] stones, int k) {

        int min = 0;
        int max = 0;
        int mid = 0;


        for (int i = 0; i < stones.length; i++) {
            max = Math.max(stones[i], max);
        }

        while(min <= max){
            mid = (min + max) / 2;

            if(!isPossible(stones, k, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    private static boolean isPossible(int[] stones,int k, int mid) {
        int count = 0;

        for (int stone : stones) {
            if (stone - mid < 0) {
                // 0보다 작아서 못 건너갈 경우
                count ++;
            } else {
                count = 0;
            }
            if (count == k) {
                return false;
            }
        }
        return true;
    }
}
