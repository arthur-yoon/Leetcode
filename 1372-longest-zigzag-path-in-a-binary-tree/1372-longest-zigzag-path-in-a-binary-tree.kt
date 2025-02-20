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
    fun longestZigZag(root: TreeNode?): Int {
        var maxLength = 0

        fun dfs(node: TreeNode?, left: Int, right: Int) {
            if (node == null) return
            maxLength = maxOf(maxLength, left, right)
            dfs(node.left, right + 1, 0)
            dfs(node.right, 0, left + 1)
        }

        dfs(root, 0, 0)
        return maxLength
    }
}