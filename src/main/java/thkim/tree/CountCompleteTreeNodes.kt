package thkim.tree

import thkim.queue.TreeNode

class CountCompleteTreeNodes {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0

        var height = 0
        var left = root.left
        var right = root.right
        while (left != null && right != null) {
            height++
            left = left.left
            right = right.right
        }

        return if (left === right) (1 shl height + 1) - 1 else 1 + countNodes(root.left) + countNodes(root.right)
    }
}