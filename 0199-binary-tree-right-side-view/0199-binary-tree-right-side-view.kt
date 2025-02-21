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
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val resultList = mutableListOf<Int>()
        val queue: LinkedList<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val currentLevelSize = queue.size
            val currentLevelNodes = mutableListOf<TreeNode>()

            for (i in 0 until currentLevelSize) {
                val currentNode = queue.removeFirst()
                currentLevelNodes.add(currentNode)
                currentNode.left?.let { queue.add(it)}
                currentNode.right?.let { queue.add(it)}
            }
            resultList.add(currentLevelNodes.last().`val`)
        }
        return resultList
    }
}