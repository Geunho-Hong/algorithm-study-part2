package min.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private static final List<List<Integer>> results = new ArrayList<>();
    private static final List<Integer> tempList = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("result = " + result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursion(candidates, target, 0);

        // candidates: [2, 3, 6, 7]
        // list: [], target: 7, startIdx: 0
        // list: [2], target: 5, startIdx: 0
        // list [2, 2], target: 3, startIdx: 0
        // list [2, 2, 2], target: 1, startIdx: 0
        // list [2, 2, 2], target: -1, startIdx: 1
        // list [2, 2, 2], target: -2, startIdx: 2
        // list [2, 2, 2], target: -5, startIdx: 3
        // list [2, 2, 2], target: -6, startIdx: 4

        return results;
    }

    private static void recursion(int[] candidates, int target, int startIdx) {
        if (target == 0) {
            results.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            if((target - candidates[i]) >= 0) {
                tempList.add(candidates[i]);
                recursion(candidates, target - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            } else {
                break;
            }
        }
    }
}