data class NumPair(val num1Value: Int, val num2Value: Int)

class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val n = nums1.size
        val pairs = Array(n) { NumPair(0, 0) } // Kotlin Array 사용
        val minHeap = PriorityQueue<Int>() // Kotlin PriorityQueue 사용 (기본 최소 힙)

        var maxScore: Long = 0
        var currentSum: Long = 0
        
        // 1. NumPair 배열 생성
        for (i in 0 until n) {
            pairs[i] = NumPair(nums1[i], nums2[i])
        }

        // 2. pairs 배열 정렬 (nums2Value 내림차순)
        pairs.sortByDescending { it.num2Value } // Kotlin Collection sort 사용

        // 3. 정렬된 pairs 배열 순회
        for (i in 0 until n) {
            currentSum += pairs[i].num1Value
            minHeap.offer(pairs[i].num1Value) // Kotlin PriorityQueue offer 사용

            // 4. 힙 크기 초과 시, 최소 힙에서 제거
            if (minHeap.size > k) {
                currentSum -= minHeap.poll() // Kotlin PriorityQueue poll 사용
            }

            // 5. 힙 크기가 k일 때, 점수 계산 및 최대 점수 갱신
            if (minHeap.size == k) {
                // val currentScore = currentSum * pairs[i].num2Value
                maxScore = maxOf(maxScore, currentSum * pairs[i].num2Value) // Kotlin maxOf 사용
            }
        }
        // 6. 최대 점수 반환
        return maxScore
    }
}