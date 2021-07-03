package sujung.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>(); // node value - index
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return getNode(0, 0, preorder.length - 1, inorderMap, preorder);
    }


    private TreeNode getNode(int rootIndexForPreorder, int startIndexForInorder, int endIndexForInorder, Map<Integer, Integer> inorderMap, int[] preorder) {
        // 범위지정 예외처리
        if (rootIndexForPreorder >= preorder.length || startIndexForInorder > endIndexForInorder) {
            return null;
        }

        // preorder : root -> left -> right
        TreeNode root = new TreeNode(preorder[rootIndexForPreorder]);
        // inorder : left -> root -> right
        int rootIndexForInorder = inorderMap.get(preorder[rootIndexForPreorder]);

        // preorder의 root 다음 인덱스
        root.left = getNode(rootIndexForPreorder + 1, startIndexForInorder, rootIndexForInorder - 1, inorderMap, preorder);
        // 좌측으로 길게 뻗은 서브트리가 있는 경우 바로 right 가 아님. 좌측에 위치한 노드 개수 건너띄기
        root.right = getNode(rootIndexForPreorder + rootIndexForInorder - startIndexForInorder + 1, rootIndexForInorder + 1, endIndexForInorder, inorderMap, preorder);
        return root;
    }
}
