class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val n = text1.length
        val m = text2.length

        // 공간 최적화를 위해 더 짧은 문자열을 기준으로 DP 테이블 생성
        val (shortText, longText) = if (n < m) text1 to text2 else text2 to text1
        val shortLen = shortText.length
        val longLen = longText.length

        val dp = Array(2) { IntArray(shortLen + 1) } // 2행 DP 테이블

        for (i in 1..longLen) {
            val currentRow = i % 2 // 현재 행 인덱스 (0 또는 1)
            val prevRow = 1 - currentRow // 이전 행 인덱스 (0 또는 1)

            for (j in 1..shortLen) {
                if (longText[i - 1] == shortText[j - 1]) {
                    dp[currentRow][j] = dp[prevRow][j - 1] + 1
                } else {
                    dp[currentRow][j] = max(dp[prevRow][j], dp[currentRow][j - 1])
                }
            }
        }

        return dp[longLen % 2][shortLen] // 최종 결과 반환
    }
}