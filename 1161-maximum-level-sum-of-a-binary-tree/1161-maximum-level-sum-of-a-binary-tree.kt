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
    fun maxLevelSum(root: TreeNode?): Int {
        return root?.let {
            var maxSum = Int.MIN_VALUE
            var minLevel: Int = -1
            var currentLevel: Int = 0

            val queue: LinkedList<TreeNode> = LinkedList()
            queue.add(root)
            while (queue.isNotEmpty()) {
                currentLevel++
                val levelSize = queue.size
                var currentLevelSum: Int = 0

                for (i in 0 until levelSize) {
                    val currentNode = queue.removeFirst()
                    currentLevelSum += currentNode.`val`
                    currentNode.left?.let { queue.add(it) }
                    currentNode.right?.let { queue.add(it) }
                }

                if (currentLevelSum > maxSum) {
                    maxSum = currentLevelSum
                    minLevel = currentLevel
                }
            }
            minLevel
        } ?: 0
    }
}