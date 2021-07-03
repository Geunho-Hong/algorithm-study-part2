package sujung.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // 중위순회
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);
        return answer;
    }

    private void inorder(TreeNode node, List<Integer> answer) {
        if(node == null) return;
        if(node.left != null) inorder(node.left, answer);
        answer.add(node.val);
        if(node.right != null) inorder(node.right, answer);
    }
}
