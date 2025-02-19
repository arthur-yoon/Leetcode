class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()

        val diff1 = mutableListOf<Int>()
        val diff2 = mutableListOf<Int>()

        for (num in set1) {
            if (!set2.contains(num)) {
                diff1.add(num)
            }
        }

        for (num in set2) {
            if (!set1.contains(num)) {
                diff2.add(num)
            }
        }        

        return listOf(diff1, diff2)
    }
}