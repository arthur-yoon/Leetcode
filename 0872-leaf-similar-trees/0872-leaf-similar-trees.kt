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
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return getLeafSequence(root1) == getLeafSequence(root2)
    }

    private fun getLeafSequence(node: TreeNode?): List<Int> {
        val leafSequence = mutableListOf<Int>()

        return if (node == null) {
            leafSequence
        } else {    
            if (node.isLeafNode()) {
                leafSequence.add(node.`val`)
                leafSequence
            } else {
                leafSequence.addAll(getLeafSequence(node.left))  // 왼쪽 리프 시퀀스 추가
                leafSequence.addAll(getLeafSequence(node.right)) // 오른쪽 리프 시퀀스 추가
                leafSequence // 합쳐진 리프 시퀀스 반환
            }
        }

    }

    private fun TreeNode.isLeafNode(): Boolean {
        return this.left == null && this.right == null
    }
}