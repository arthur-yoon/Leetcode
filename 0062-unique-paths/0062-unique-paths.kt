class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 1 } }
        for (i in 1 .. m-1) {
            for (j in 1 .. n-1) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }    
        }

        return dp[m-1][n-1]
    }
}