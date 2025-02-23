class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0 // XOR 누적 변수 초기화
        for (num in nums) { // nums 배열 순회
            result = result xor num // XOR 연산 누적
        }

        return result // 결과 반환
    }
}

// 시간 O(n)
// 공간 O(1)
// 음수가능

// 4 xor 1 xor 2 xor 1 xor 2 라는 표현은 [4, 1, 2, 1, 2] 배열의 모든 요소에 XOR 연산을 적용
// 교환, 결합법칙 가능