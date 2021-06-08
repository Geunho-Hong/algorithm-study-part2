package min.queue;

import java.util.*;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
//        TreeNode t5 = new TreeNode(5, null, null);
//        TreeNode t2 = new TreeNode(2, null, t5);
//        TreeNode t3 = new TreeNode(3, null, null);
//        TreeNode root = new TreeNode(1, t2, t3);

        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, t2, null);

        List<Integer> result = rightSideView(root);
        System.out.println("result = " + result);
    }

    //        1             ---- LEVEL 1
    //       / \
    //      2   3           ---- LEVEL 2
    //       \   \
    //       5   4          ---- LEVEL 3

    // Queue ->> []

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 결과 배열
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // 현재 Queue 의 크기 = 현재 Level 의 노드 개수
            int size = q.size();
            // 현재 Level 의 노드 개수만큼 반복
            for (int i = 0; i < size; i++) {
                // Queue 에서 꺼낸 노드의 left, right 노드를 queue 에 넣는다.
                TreeNode curNode = q.poll();

                // i 의 값이 size - 1 이면 반복의 마지막이기 때문에 현재 노드의 값을 결과에 담아줌
                if (i == size -1)
                    result.add(curNode.val);

                if (curNode.left != null)
                    q.offer(curNode.left);

                if (curNode.right != null)
                    q.offer(curNode.right);
            }
        }

        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
