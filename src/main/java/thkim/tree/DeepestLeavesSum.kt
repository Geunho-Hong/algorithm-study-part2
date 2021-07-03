package thkim.tree

class DeepestLeavesSum {
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = ArrayDeque<TreeNode?>()

        queue.addFirst(root)

        var sum = 0

        while (queue.isNotEmpty()) {
            var size = queue.size

            sum = 0

            while (size-- > 0) {
                val data = queue.removeLast()!!

                sum += data.`val`

                if (data.left != null) queue.addFirst(data.left)

                if (data.right != null) queue.addFirst(data.right)
            }
        }

        return sum
    }
}