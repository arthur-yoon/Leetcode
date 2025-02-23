class Solution {
    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1) // 크기 (n+1) 의 정수 배열 생성

        ans[0] = 0 // Base Case: ans[0] = 0

        for (i in 1..n) { // 1부터 n까지 반복
            if (i % 2 == 0) { // 짝수 조건
                ans[i] = ans[i / 2] // 점화식: 짝수
            } else { // 홀수 조건
                ans[i] = ans[i / 2] + 1 // 점화식: 홀수
            }
        }
        return ans // 결과 배열 반환
    }
}