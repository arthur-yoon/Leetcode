class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            var mid = (left + right) / 2
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}