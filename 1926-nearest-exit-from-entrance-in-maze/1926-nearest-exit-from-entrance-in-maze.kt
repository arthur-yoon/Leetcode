class Solution {
    data class Direction(val rowDelta: Int, val colDelta: Int)

        private val directions = arrayOf(
        Direction(0, 1),  // Right
        Direction(0, -1), // Left
        Direction(1, 0),  // Down
        Direction(-1, 0) // Up
    )

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val m = maze.size
        val n = maze[0].size
        val startRow = entrance[0]
        val startCol = entrance[1]

        val queue: LinkedList<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        val visited = HashSet<Pair<Int, Int>>()
        var steps = 0

        queue.addLast(Pair(startRow, startCol))
        visited.add(Pair(startRow, startCol))

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            // repeat (lelveSize) {...}
            for (i in 0 until levelSize) {
                val current = queue.removeFirst()
                val currentRow = current.first
                val currentCol = current.second

                if (isExit(currentRow, currentCol, m, n, startRow, startCol)) {
                    return steps
                }

                for (direction in directions) {
                    val nextRow = currentRow + direction.rowDelta
                    val nextCol = currentCol + direction.colDelta

                    if (isValid(nextRow, nextCol, m, n, maze, visited)) {
                        visited.add(Pair(nextRow, nextCol))
                        queue.addLast(Pair(nextRow, nextCol))
                    }
                }
            }
            steps++
        }
        return -1
    }

    private fun isExit(row: Int, col: Int, m: Int, n: Int, startRow: Int, startCol: Int): Boolean {
        return (row == 0 || row == m - 1 || col == 0 || col == n - 1) && !(row == startRow && col == startCol)
    }

    private fun isValid(row: Int, col: Int, m: Int, n: Int, maze: Array<CharArray>, visited: HashSet<Pair<Int, Int>>): Boolean {
        return row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == '.' && !visited.contains(Pair(row, col))
    }
}