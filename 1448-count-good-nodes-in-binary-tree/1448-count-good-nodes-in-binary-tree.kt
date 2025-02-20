/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var goodNodeCount = 0

        fun getGoodNodeCount(node: TreeNode?, maxValueOfPath: Int)  {
            if (node == null) {
                return
            } else {
                if (node.isGoodNode(maxValueOfPath)) {
                    goodNodeCount++
                    getGoodNodeCount(node.left, node.`val`)
                    getGoodNodeCount(node.right, node.`val`)
                } else {
                    getGoodNodeCount(node.left, maxValueOfPath)
                    getGoodNodeCount(node.right, maxValueOfPath)
                }
            }
        }

        root?.let {
            getGoodNodeCount(it, it.`val`)
        }
        return goodNodeCount
    }

    private fun TreeNode.isGoodNode(maxValueOfPath: Int): Boolean {
        return this.`val` >= maxValueOfPath
    }


}