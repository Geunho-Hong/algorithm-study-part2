package min.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DeepestLeavesSum {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        sumValue(root, 1);

        Optional<Integer> largestDepth = map.keySet().stream().max(Integer::compareTo);
        if (largestDepth.isPresent()) {
            return map.get(largestDepth.get());
        }
        return 0;
    }

    private void sumValue(TreeNode node, int depth) {
        if (node != null) {
            map.put(depth, map.getOrDefault(depth, 0) + node.val);
            depth++;
            sumValue(node.left, depth);
            sumValue(node.right, depth);
        }
    }
}