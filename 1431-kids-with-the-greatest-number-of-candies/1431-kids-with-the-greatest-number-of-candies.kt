class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val result = BooleanArray(candies.size)
        val maxCandy = candies.maxOrNull() ?: 0

        candies.forEachIndexed { index, candyCount ->
            val currentCandy = candyCount + extraCandies
            result[index] = currentCandy >= maxCandy
        }
        return result
    }
}