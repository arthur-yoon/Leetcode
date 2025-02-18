class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val n = nums.size
        if (k > n) { // 문제 조건에서 k <= n 이므로 실제로는 불필요하지만, 안전을 위해 추가
            throw IllegalArgumentException("k cannot be greater than n")
        }

        var currentSum: Double = 0.0 // Double 형으로 초기화하여 평균 계산 시 소수점 유지
        for (i in 0 until k) { // 초기 윈도우 합 계산 (indices 대신 until 사용)
            currentSum += nums[i]
        }

        var maxSum = currentSum // 최대 합 초기화

        for (i in k until n) { // 윈도우 슬라이딩 (indices 대신 until 사용)
            currentSum = currentSum - nums[i - k] + nums[i] // 윈도우 업데이트
            maxSum = maxOf(maxSum, currentSum) // 최대 합 갱신
        }

        return maxSum / k // 최대 평균값 반환 (Double 형 나눗셈)
    }
}