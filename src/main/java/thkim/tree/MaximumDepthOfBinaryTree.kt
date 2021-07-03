package thkim.tree

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = ArrayDeque<TreeNode?>()

        queue.addFirst(root)

        var n = 0

        while (queue.isNotEmpty()) {
            var size = queue.size

            while (size-- > 0) {
                val value = queue.removeLast()!!

                if (size == 0) n++

                if (value.left != null) queue.addFirst(value.left)

                if (value.right != null) queue.addFirst(value.right)
            }
        }

        return n
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}