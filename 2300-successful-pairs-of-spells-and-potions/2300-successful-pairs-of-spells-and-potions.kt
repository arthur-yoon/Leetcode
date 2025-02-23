class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val n = spells.size
        val m = potions.size
        val resultPair = IntArray(n)
        
        potions.sort()

        for (i in 0 until n) {
            val spell = spells[i]
            val required = (success+ spell -1) / spell

            var leftIndex = 0
            var rightIndex = m - 1
            var firstSuccessPotionIndex = m

            while (leftIndex <= rightIndex) {
                val midIndex = leftIndex + (rightIndex - leftIndex) / 2
                if (potions[midIndex].toLong() >= required) {
                    firstSuccessPotionIndex = midIndex
                    rightIndex = midIndex - 1
                } else {
                    leftIndex = midIndex + 1
                }
            }
            resultPair[i] = m - firstSuccessPotionIndex
        }
        return resultPair
    }
}
