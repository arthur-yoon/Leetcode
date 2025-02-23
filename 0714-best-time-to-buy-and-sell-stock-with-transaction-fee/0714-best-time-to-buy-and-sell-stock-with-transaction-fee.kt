class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val period = prices.size
        if (period == 0) return period

        val cash = IntArray(period){ 0 }
        val hold = IntArray(period){ 0 }
        hold[0] = -prices[0] // 주식 보유시 현금 -

        for (i in 1 until period) {
            cash[i] = maxOf(cash[i-1], hold[i-1] + prices[i] - fee)
            hold[i] = maxOf(hold[i-1], cash[i-1] - prices[i])
        }
        return cash[period-1]
    }
}