package thkim.tree

class BinaryTreeInorderTraversal {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()

        fun recursion(root: TreeNode?) {

            if (root != null) {
                recursion(root.left)
                list.add(root.`val`)
                recursion(root.right)
            }
        }

        recursion(root)

        return list.toList()
    }
}