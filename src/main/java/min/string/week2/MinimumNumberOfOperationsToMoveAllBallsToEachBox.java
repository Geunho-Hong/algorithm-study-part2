package min.string.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public static void main(String[] args) {
        int[] result = new MinimumNumberOfOperationsToMoveAllBallsToEachBox().minOperations("001011");
        System.out.println(Arrays.toString(result));
    }

    public int[] minOperations(String boxes) {
        int boxesLength = boxes.length();

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < boxesLength; i++) {
            if (boxes.charAt(i) == '1') {
                indexes.add(i);
            }
        }

        int[] result = new int[boxesLength];
        for (int i = 0; i < boxesLength; i++) {
            int sum = 0;
            for (Integer index : indexes) {
                sum += Math.abs(index - i);
            }
            result[i] = sum;
        }

        return result;
    }

}
