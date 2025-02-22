class Solution {
    data class Direction(val rowDelta: Int, val colDelta: Int)

    private val directions = arrayOf( // Offset 배열
        Direction(0, 1),  // Right
        Direction(0, -1), // Left
        Direction(1, 0),  // Down
        Direction(-1, 0) // Up
    )

    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val queue: LinkedList<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>() // BFS 큐
        var minutes = 0
        var freshOranges = 0

        // 1. 초기 썩은 오렌지 큐에 Enqueue, 신선한 오렌지 개수 카운트
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 2) { // 썩은 오렌지
                    queue.addLast(Pair(i, j)) // Enqueue: LinkedList 기능 사용
                } else if (grid[i][j] == 1) { // 신선한 오렌지
                    freshOranges++
                }
            }
        }

        if (freshOranges == 0) { // 초기 신선한 오렌지 없으면 0분 반환
            return 0
        }

        // 2. BFS 시뮬레이션: 썩은 오렌지 전파
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            if (levelSize == 0 && freshOranges > 0) { // 큐가 비었고, 신선한 오렌지 남음 -> 불가능
                return -1
            }
            repeat(levelSize) {
                val current = queue.removeFirst() // Dequeue: LinkedList 기능 사용
                val currentRow = current.first
                val currentCol = current.second

                for (direction in directions) { // Offset 배열 순회
                    val nextRow = currentRow + direction.rowDelta // Offset 적용
                    val nextCol = currentCol + direction.colDelta // Offset 적용

                    if (isValid(nextRow, nextCol, m, n)) {
                        if (grid[nextRow][nextCol] == 1) { // 인접 셀이 신선한 오렌지
                            grid[nextRow][nextCol] = 2 // 썩게 만들기 (격자 값 변경)
                            freshOranges-- // 신선한 오렌지 감소
                            queue.addLast(Pair(nextRow, nextCol)) // Enqueue: LinkedList 기능 사용
                        }
                    }
                }
            }
            minutes++ // 1분 경과
        }

        // 3. BFS 종료 후 신선한 오렌지 남았는지 확인
        return if (freshOranges > 0) -1 else minutes - 1 // 신선한 오렌지 남았으면 -1, 아니면 최소 시간 반환 (minutes-1 보정)
    }

    private fun isValid(row: Int, col: Int, m: Int, n: Int): Boolean { // 유효 좌표 확인 함수 (격자 범위 내)
        return row >= 0 && row < m && col >= 0 && col < n
    }
}