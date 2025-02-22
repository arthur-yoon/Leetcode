class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>() // 최소힙

        for (num in nums) {
            minHeap.offer(num)

            if (minHeap.size > k) {
                minHeap.poll() // 최소값 제거
            }
        }
        return minHeap.poll()
    }
}