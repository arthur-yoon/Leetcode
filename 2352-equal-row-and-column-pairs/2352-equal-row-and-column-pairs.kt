//  sol_1 수평비교, 수직비교
class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val n = grid.size
        var count = 0

        for (ri in 0 until n) {
            for (cj in 0 until n) {
                var isEqual = true
                for (k in 0 until n) {
                    if (grid[ri][k] != grid[k][cj]) {
                        isEqual = false
                        break
                    }
                }
                if (isEqual) {
                    count++
                }
            }
        }
        return count
    }
}