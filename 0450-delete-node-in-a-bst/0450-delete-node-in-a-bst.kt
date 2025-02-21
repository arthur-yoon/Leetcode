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
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        return root?.let { currentRoot -> // 람다 내에서 root를 currentRoot로 사용 (가독성 향상)
            when {
                key < currentRoot.`val` -> {
                    currentRoot.left = deleteNode(currentRoot.left, key) // key가 작으면 왼쪽 서브트리 탐색 (수정 완료)
                    currentRoot // 왼쪽 서브트리 삭제 후 현재 루트 반환
                }
                key > currentRoot.`val` -> {
                    currentRoot.right = deleteNode(currentRoot.right, key) // key가 크면 오른쪽 서브트리 탐색 (수정 완료)
                    currentRoot // 오른쪽 서브트리 삭제 후 현재 루트 반환
                }
                key == currentRoot.`val` -> { // 삭제할 노드 찾음
                    when {
                        currentRoot.left == null && currentRoot.right == null -> null // Case 1: 리프 노드 (null 반환)
                        currentRoot.left == null -> currentRoot.right          // Case 2: 오른쪽 자식만 있음 (오른쪽 자식 반환)
                        currentRoot.right == null -> currentRoot.left           // Case 2: 왼쪽 자식만 있음 (왼쪽 자식 반환)
                        else -> { // Case 3: 자식 노드 2개 (Inorder Successor 활용)
                            val successorValue = findMinVal(currentRoot.right!!) // 오른쪽 서브트리에서 Successor 값 찾기
                            currentRoot.`val` = successorValue               // 현재 노드 값을 Successor 값으로 변경
                            currentRoot.right = deleteNode(currentRoot.right, successorValue) // 오른쪽 서브트리에서 Successor 삭제
                            currentRoot // Successor 대체 후 현재 루트 반환
                        }
                    }
                }
                else -> currentRoot // else 분기 제거 (도달 불가능) - 안전을 위해 남겨둘 수도 있지만, 여기서는 제
            }
        }
    }

    // Helper function: 오른쪽 서브트리에서 최소값 (Inorder Successor) 찾기
    private fun findMinVal(node: TreeNode): Int {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current.`val`
    }
}

// 키값 가지는 노드 탐색
// 리프노드면 제거(null)
// 자식노드 1개 -> 해당 노드로 대체
// 자식노드 1개 우측 노드 있으면 변경

// [5,3,6,2,4,null,7]
// [5,4,6,2,null,null,7]