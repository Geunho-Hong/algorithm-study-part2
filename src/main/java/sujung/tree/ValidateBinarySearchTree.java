package sujung.tree;

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, TreeNode left, TreeNode right) {
        if (node == null) return true;

        // 이진 탐색 트리의 특성 : left child < root < right child
        if (node.left != null && node.val < left.val) {
            return false;
        }
        if (node.right != null && node.val > right.val) {
            return false;
        }
        return validate(node.left, left, node)
                && validate(node.right, node, right);

    }

}
