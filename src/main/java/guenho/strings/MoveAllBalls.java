package guenho.strings;

// https://massivealgorithms.blogspot.com/2021/04/leetcode-1769-minimum-number-of.html
// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

public class MoveAllBalls {
    public static void main(String[] args) {
        String boxes = "110";
        int[] answer = minOperations(boxes);

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }

    private static int[] minOperations(String boxes) {
        char[] balls = boxes.toCharArray();
        int boxLength = balls.length;
        int[] answer = new int[boxLength];

        /**
         *  Math.abs(i-j) -> distance를 구한다
         */

        for (int i = 0; i < boxLength; i++) {
            int temp = 0;
            for (int j = 0; j < boxLength; j++) {
                if (i != j && balls[j] == '1') {
                    temp += Math.abs(i - j);
                }
            }
            answer[i] = temp;
        }
        return answer;
    }
}
