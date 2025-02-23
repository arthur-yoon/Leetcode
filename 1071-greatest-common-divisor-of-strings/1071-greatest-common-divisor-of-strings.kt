class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        // 짧은 문자열의 길이
        val minLength = minOf(str1.length, str2.length)

        // minLength 부터 1까지 감소하며 반복 (divisorLength)
        for (divisorLength in minLength downTo 1) {
            // 잠재적 약수 prefix = str1의 처음부터 divisorLength 길이만큼 잘라낸 문자열
            val prefix = str1.substring(0, divisorLength)

            // 의사코드 5. 함수 isDivisor(문자열 s, 잠재적 약수 t)
            fun isDivisor(s: String, t: String): Boolean {
                // s가 t로 시작하지 않으면, 거짓
                if (!s.startsWith(t)) {
                    return false
                }
                // 코틀린 기능 활용: buildString, repeat
                val tempS = buildString {
                    repeat(s.length / t.length) {
                        append(t)
                    }
                }
                return tempS == s
            }
            if (isDivisor(str1, prefix) && isDivisor(str2, prefix)) {
                return prefix // 가장 큰 공통 약수 찾음
            }
        }

        // 반복문이 끝났지만 공통 약수를 찾지 못함: 빈 문자열 "" 반환
        return ""
    }
}