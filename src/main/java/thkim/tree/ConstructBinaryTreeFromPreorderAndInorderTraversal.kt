package thkim.tree


class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    var preorderIndex = 0
    var inorderIndexMap: MutableMap<Int, Int> = mutableMapOf()

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        preorderIndex = 0
        // build a hashmap to store value -> its index relations
        for (i in inorder.indices) inorderIndexMap[inorder[i]] = i

        return arrayToTree(preorder, 0, preorder.size - 1)
    }

    private fun arrayToTree(preorder: IntArray, left: Int, right: Int): TreeNode? {
        // if there are no elements to construct the tree
        if (left > right) return null

        // select the preorder_index element as the root and increment it
        val rootValue = preorder[preorderIndex++]
        val root = TreeNode(rootValue)

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(
            preorder = preorder,
            left = left,
            right = inorderIndexMap[rootValue]!! - 1
        )

        root.right = arrayToTree(
            preorder = preorder,
            left = inorderIndexMap[rootValue]!! + 1,
            right = right
        )

        return root
    }
}