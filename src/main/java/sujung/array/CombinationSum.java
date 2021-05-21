package sujung.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        compute(candidates, target, 0, combination, result);
        return result;
    }

    private void compute(int[] candidates, int remain, int depth, List<Integer> combination, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = depth; i < candidates.length; i++) {
            if (remain - candidates[i] < 0) continue;
            combination.add(candidates[i]);
            compute(candidates, remain - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
