class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var right = nums.size - 1
        var opCount = 0

        while (left < right) {
            val currentSum = nums[left] + nums[right]
            if (currentSum == k) {
                opCount++
                left++
                right--
            } else if (currentSum < k) {
                left++
            } else {
                right--
            }
        }
        return opCount
    }
}