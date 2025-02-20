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
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head == null || head.next == null) { 
            return null
        }

        var slowPointer = head // 느린 포인터: 중간 노드 찾기
        var fastPointer = head // 빠른 포인터: 리스트 끝 확인
        var previousPointer: ListNode? = null // 이전 포인터: 삭제 연산


        while (fastPointer?.next != null) { // while: fastPointer가 리스트 끝까지 이동
            fastPointer = fastPointer.next?.next // Fast Pointer 2칸 이동
            previousPointer = slowPointer // Slow Pointer 이동 전 위치 저장
            slowPointer = slowPointer?.next // Slow Pointer 1칸 이동
        }
        // while 종료: slowPointer == 중간 노드, previousPointer == 이전 노드
        previousPointer?.next = slowPointer?.next // 이전 포인터의 next를 slowPointer 다음으로 연결
        return head
    }
}