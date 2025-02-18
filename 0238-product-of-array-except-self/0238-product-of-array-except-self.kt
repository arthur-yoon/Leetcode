class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val answer = IntArray(n) // 결과 배열 answer 초기화 (O(n) 공간, 문제 조건에서 출력 배열 공간은 extra space 로 count 하지 않음)

        // 의사코드 3. Prefix 곱 계산 (answer 배열에 저장)
        // 의사코드 4. answer[0] = 1  // prefix 곱 초기값
        answer[0] = 1
        // 의사코드 5. for i = 1 부터 nums.length - 1 까지:
        for (i in 1 until n) { // 컬렉션 기능 활용: until (1부터 n-1 까지)
            // 의사코드 6. answer[i] = answer[i-1] * nums[i-1] // 이전 prefix 곱 * nums[i-1]
            answer[i] = answer[i - 1] * nums[i - 1]
        }

        // 의사코드 7. Suffix 곱 계산 및 최종 결과 계산 (answer 배열 업데이트)
        // 의사코드 8. suffix 곱 초기값 suffixProduct = 1
        var suffixProduct = 1
        // 의사코드 9. for i = nums.length - 1 부터 0 까지 (역순 순회):
        for (i in n - 1 downTo 0) { // 컬렉션 기능 활용: downTo (역순 순회)
            // 의사코드 10. answer[i] = answer[i] * suffixProduct  // answer[i] (prefix 곱) * suffix 곱
            answer[i] = answer[i] * suffixProduct
            // 의사코드 11. suffixProduct = suffixProduct * nums[i] // suffix 곱 업데이트 (현재 요소 포함)
            suffixProduct *= nums[i] // 코틀린 스타일: 복합 대입 연산자 (*=)
        }

        // 의사코드 12. 결과 배열 answer 반환
        return answer
    }
}