class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        if (n <= 1) return cost[n - 1] // 계단이 0개 또는 1개인 경우 예외 처리 (index out of bound 방지)

        val dp = IntArray(n)
        dp[0] = cost[0]
        dp[1] = cost[1]

        for (i in 2 until n) {
            dp[i] = cost[i] + minOf(dp[i - 1], dp[i - 2]) // dp2 = cost2 + min(cost1 -> 15, cost0 -> 10) = 20 + 10 = 30
        }

        return min(dp[n - 1], dp[n - 2])
    }
}