package sujung.tree;

public class CountCompleteTreeNodes {
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

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        // 트리 높이
        int leftHeight = getHeight(root, 'L');
        int rightHeight = getHeight(root, 'R');
        // 좌측 끝과 우측 끝의 높이 같다면 포화이진트리
        if(leftHeight == rightHeight) {
            return (1 << (leftHeight + 1)) - 1;
        }
        // 아니라면 자식 노드로 내려가서 재계산, 현재 노드 + 좌우 서브트리의 노드 개수
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getHeight(TreeNode node, char side) {
        if (node == null) return 0;
        if (side == 'L' && node.left != null) {
            return getHeight(node.left, 'L') + 1;
        }
        if (side == 'R' && node.right != null) {
            return getHeight(node.right, 'R') + 1;
        }
        return 0;
    }
}
