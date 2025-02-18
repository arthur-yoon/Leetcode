class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }
        var firstMin = Int.MAX_VALUE
        var secondMin = Int.MAX_VALUE

        for (number in nums) {
            when {
                number <= firstMin -> firstMin = number
                number <= secondMin -> secondMin = number
                else -> return true
            }
        }

        return false
    }
}