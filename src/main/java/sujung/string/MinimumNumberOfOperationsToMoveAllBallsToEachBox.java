package sujung.string;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    /**
     * 공의 이동 횟수 : dp[i] = dp[i-1] + balls
     * 특정 박스의 양쪽에서 공이 이동해올 수 있기 때문에 left, right side 모두에 대해 계산 필요
     *
     * @param boxes
     * @return
     */
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] result = new int[length];

        int prev = 0;
        int val = boxes.charAt(0) - '0';
        for (int i = 1; i < length; i++) {
            prev += val;
            result[i] += prev;
            val += boxes.charAt(i) - '0';
        }

        prev = 0;
        val = boxes.charAt(length - 1) - '0';
        for (int i = length - 2; i >= 0; i--) {
            prev += val;
            result[i] += prev;
            val += boxes.charAt(i) - '0';
        }
        return result;
    }
}
