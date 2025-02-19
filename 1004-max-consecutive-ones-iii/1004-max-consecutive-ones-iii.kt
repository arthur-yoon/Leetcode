class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var windowStart = 0
        var zeroCount = 0
        var maxLength = 0

        for (windowEnd in 0 until nums.size) {
            if (nums[windowEnd] == 0) {
                zeroCount++
            }
            
            while (zeroCount > k) {
                if (nums[windowStart] == 0) {
                    zeroCount--
                }
                windowStart++
            }
            maxLength = max(maxLength, windowEnd - windowStart + 1)
        }
        return maxLength
    }
}