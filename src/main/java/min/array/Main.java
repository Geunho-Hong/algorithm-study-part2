package min.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1, 1);


        int[] numbers = new int[4];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;

        int[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(newNumbers));
    }

}
