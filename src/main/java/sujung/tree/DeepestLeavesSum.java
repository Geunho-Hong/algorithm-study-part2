package sujung.tree;

public class DeepestLeavesSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int deepestLeavesSum(TreeNode root) {
        int height = maxDepth(root);
        int answer = computeSum(root, height);
        return answer;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = maxDepth(node.left);
        }
        if (node.right != null) {
            rightHeight = maxDepth(node.right);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int computeSum(TreeNode node, int level) {
        if (node == null) return 0;
        if (level == 1) return node.val;
        return computeSum(node.left, level - 1) + computeSum(node.right, level - 1);
    }
}
