package guenho.month_october;

import java.util.HashSet;
import java.util.Set;

public class AddNonExistNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
    }

    private int solution(int[] numbers) {

        int sum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            set.add(numbers[i]);
        }

        for (int i = 0; i < 10; i++) {
            if(!set.contains(i)) {
                sum += i;
            }
        }

        return sum;
    }

}
