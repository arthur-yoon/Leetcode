class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var windowStart = 0
        var zeroCount = 0
        var maxLength = 0
        if (!nums.contains(1)) {
            return 0
        }
        for (windowEnd in 0 until nums.size) {
            if (nums[windowEnd] == 0) {
                zeroCount++
            }
            while (zeroCount > 1) {
                if (nums[windowStart] == 0) {
                    zeroCount--
                }
                windowStart++
            }
            maxLength = maxOf(maxLength, windowEnd - windowStart + 1)
        }

        return maxLength - 1
    }
}