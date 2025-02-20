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
fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if(root == null) return 0
        val pathSumNode = pathSumNode(root,targetSum.toLong())
        val pathSumLeft = pathSum(root.left, targetSum)
        val pathSumRight = pathSum(root.right, targetSum)   
        return pathSumNode + pathSumLeft + pathSumRight
    }
    
    fun pathSumNode(root : TreeNode?, targetSum : Long) : Int{
        if(root == null) return 0
        var count = 0
        if(targetSum - root.`val` == 0L) count++
        count += pathSumNode(root.left, targetSum - root.`val` )
        count += pathSumNode(root.right, targetSum - root.`val`)
        return count
    }
}