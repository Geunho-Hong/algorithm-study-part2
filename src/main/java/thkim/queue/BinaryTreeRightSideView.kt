package thkim.queue

import java.util.*

class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return arrayListOf()

        val queue: Queue<TreeNode?> = LinkedList()

        queue.offer(root)

        val res: MutableList<Int> = mutableListOf()

        while (!queue.isEmpty()) {
            var size: Int = queue.size

            while (size-- > 0) {
                val cur: TreeNode = queue.poll()!!

                if (size == 0) res.add(cur.`val`)

                if (cur.left != null) queue.offer(cur.left)

                if (cur.right != null) queue.offer(cur.right)
            }
        }

        return res
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}