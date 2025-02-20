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
    // recursively
    // fun reverseList(head: ListNode?): ListNode? {
    //     if (head == null || head.next == null) {
    //         return head
    //     }

    //     val result = reverseList(head.next) // head.next 이후 리스트 재귀적으로 뒤집기
    //     head.next.next = head // head.next의 next를 head로 (역방향 연결)
    //     head.next = null      // head의 next를 null로 (원래 방향 연결 끊기)
    //     return result
    // }
    // iteratively
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }

        var nextTemp: ListNode?  // 다음 노드 임시 저장 포인터
        var prev: ListNode? = null // 이전 노드 포인터
        var current = head      // 현재 노드 포인터

        while (current != null) { // while 루프: current가 null이 아닐 때까지
            nextTemp = current.next // 다음 노드 임시 저장
            current.next = prev     // 현재 노드의 next를 이전 노드로 변경 (역방향 연결)
            prev = current          // 이전 노드를 현재 노드로 갱신
            current = nextTemp      // 현재 노드를 다음 노드로 갱신
        }
        return prev // 뒤집힌 리스트의 head는 prev가 가리킴
    }
}