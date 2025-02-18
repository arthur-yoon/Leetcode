class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var write = 0 // write pointer

        // Move all non-zero elements to the front of the array
        nums.forEachIndexed { index, number -> // forEachIndexed 로 인덱스, 요소 동시 접근
            if (number != 0) {
                nums[write++] = number
            }
        }

        // Fill the rest of the array with 0s
        for (i in write until nums.size) {
            nums[i] = 0
        }
    }
}