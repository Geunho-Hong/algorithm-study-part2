package min.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private static int rootIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int[] inorder, int inStartIdx, int inEndIdx) {
        if (inStartIdx > inEndIdx || rootIndex >= preorder.length) {
            rootIndex--;
            return null;
        }

        TreeNode root = new TreeNode(preorder[rootIndex]);

        int inIdx = 0;
        for (int i = inStartIdx; i <= inEndIdx; i++) {
            if (inorder[i] == root.val) {
                inIdx = i;
                break;
            }
        }

        rootIndex++;
        root.left = helper(preorder, inorder, inStartIdx, inIdx - 1);
        rootIndex++;
        root.right = helper(preorder, inorder, inIdx + 1, inEndIdx);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};

        TreeNode rootNode = buildTree(preorder, inorder);

        System.out.println(rootNode.val);
    }

}
