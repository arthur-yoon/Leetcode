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
    fun oddEvenList(head: ListNode?): ListNode? {
       if (head == null || head.next == null) return head
        val oddHead = head // 홀수 리스트 head
        val evenHead = head.next // 짝수 리스트 head
        var oddTail = oddHead // 홀수 리스트 tail
        var evenTail = evenHead // 짝수 리스트 tail
        var current = evenHead.next // 현재 노드, 3번째 노드부터 시작
        while (current != null) { // while: current가 null이 아닐 때까지 순회
            oddTail?.next = current // 홀수 tail의 next를 current에 연결
            oddTail = current // 홀수 tail 갱신
            current = current.next // current를 다음 노드로 이동 (짝수 노드 차례)
            if (current != null) { // if: current가 null이 아니면 (짝수 노드 처리)
                evenTail?.next = current // 짝수 tail의 next를 current에 연결
                evenTail = current // 짝수 tail 갱신
                current = current.next // current를 다음 노드로 이동 (홀수 노드 차례)
            }
        }
        oddTail?.next = evenHead // 홀수 tail의 next를 evenHead에 연결
        evenTail?.next = null // 짝수 tail의 next를 null로 설정 (리스트 종료)
        return oddHead // 재정렬된 리스트 head 반환
    }
}