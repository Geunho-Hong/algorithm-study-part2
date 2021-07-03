package min.tree;

public class CountCompleteTreeNodes {

    private int count;

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int leftLv = 0;
        int rightLv = 0;

        TreeNode left = root;
        TreeNode right = root;

        while (left != null) {
            left = left.left;
            leftLv++;
        }

        while (right != null) {
            right = right.right;
            rightLv++;
        }

        if (leftLv == rightLv) return (int) Math.pow(2, leftLv) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes_1(TreeNode root) {
        inorder(root);
        return count;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            count++;
            inorder(root.right);
        }
    }

}