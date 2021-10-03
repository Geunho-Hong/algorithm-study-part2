package sujung.binarysearch;

public class CrossingSteppingStones {
    public int solution(int[] stones, int k) {
        int max = 1;
        int min = 1;
        for (int i = 0; i < stones.length; i++) {
            max = Math.max(stones[i], max);
        }

        int left = min;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(isPossibleToCross(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean isPossibleToCross(int[] stones, int k, int mid) {
        int count = 0;
        for(int i=0; i<stones.length; i++) {
            if(stones[i] - mid <= 0) count++;
            else count = 0;

            if(count >= k) {
                return false;
            }
        }
        return true;
    }
}
