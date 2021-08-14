package min.toss;

import java.util.*;

public class Solution_5 {

    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();
        int[] solution1 = solution.solution(new int[]{30, 40, 10, 20, 30}, 3);
        System.out.println(Arrays.toString(solution1));
    }

    public int[] solution(int[] fruitWeights, int k) {
        Set<Integer> result = new HashSet<>();

        // length = 5 - 3 = 2
        for (int i = 0; i <= fruitWeights.length - k; i++) {
            List<Integer> maxList = new ArrayList<>();
            for (int j = i; j < i + k; j++) {
                maxList.add(fruitWeights[j]);
            }
            result.add(maxList.stream().max(Integer::compare).get());
            maxList.clear();
        }

        int[] resArr = new int[result.size()];
        Integer[] integers = result.toArray(Integer[]::new);
        Arrays.sort(integers, Comparator.reverseOrder());

        for (int i = 0; i < integers.length; i++) {
            resArr[i] = integers[i];
        }

        return resArr;
    }

}
