package min.tree;

public class MaximumDepthOfBinaryTree {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        computeDepth(root, 0);
        return maxDepth;
    }

    private void computeDepth(TreeNode node, int depth) {
        if (node != null) {
            maxDepth = Math.max(maxDepth, ++depth);
            computeDepth(node.left, depth);
            computeDepth(node.right, depth);
        }
    }
}
