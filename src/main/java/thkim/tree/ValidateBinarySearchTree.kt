package thkim.tree

class ValidateBinarySearchTree {

    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun isValidBST(root: TreeNode?, minVal: Long, maxVal: Long): Boolean {
        if (root == null) return true

        return if (root.`val` >= maxVal || root.`val` <= minVal) false
        else isValidBST(root.left, minVal, root.`val`.toLong()) && isValidBST(root.right, root.`val`.toLong(), maxVal)
    }

}