package guenho.codility;

import java.util.HashMap;
import java.util.Map;

public class AddOccurencesInArray {
    public static void main(String[] args) {
        int[] arr = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {

        Map<Integer, Integer> paramMap = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            paramMap.put(arr[i], paramMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> pair : paramMap.entrySet()) {
            if (pair.getValue() % 2 == 1) {
                // odd Number
                answer = pair.getKey();
            }
        }
        return answer;
    }
}
