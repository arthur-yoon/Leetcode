/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun pairSum(head: ListNode?): Int {
        val nodeList = mutableListOf<Int>()
        var temp = head
        while (temp != null) {
            nodeList.add(temp.`val`)
            temp = temp.next
        }
        var max = 0
        val n = nodeList.size
        nodeList.forEachIndexed { i, value ->
            max = maxOf(max, value + nodeList[n -1 - i]) 
        }
        return max
    }
}