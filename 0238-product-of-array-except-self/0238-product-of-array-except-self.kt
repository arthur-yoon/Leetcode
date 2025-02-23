class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val answer = IntArray(n)

        // Prefix 곱 계산 (answer 배열에 저장)
        answer[0] = 1

        // for i = 1 부터 nums.length - 1
        for (i in 1 until n) {
            // answer[i] = 이전 prefix 곱 * nums[i-1]
            answer[i] = answer[i - 1] * nums[i - 1]
        }
        // suffix 곱 초기값 suffixProduct = 1
        var suffixProduct = 1
        for (i in n - 1 downTo 0) { // 컬렉션 기능 활용: downTo (역순 순회)
            // answer[i] = answer[i] * suffixProduct  // answer[i] (prefix 곱) * suffix 곱
            answer[i] = answer[i] * suffixProduct
            // suffixProduct = suffixProduct * nums[i] // suffix 곱 업데이트 (현재 요소 포함)
            suffixProduct *= nums[i] // 코틀린 스타일: 복합 대입 연산자 (*=)
        }
        return answer
    }
}