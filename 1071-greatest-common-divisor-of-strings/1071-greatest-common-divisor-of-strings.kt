class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        // 의사코드 2. 짧은 문자열의 길이 minLength = min(str1의 길이, str2의 길이)
        val minLength = minOf(str1.length, str2.length)

        // 의사코드 3. minLength 부터 1까지 감소하며 반복 (divisorLength)
        for (divisorLength in minLength downTo 1) {
            // 의사코드 4. 잠재적 약수 prefix = str1의 처음부터 divisorLength 길이만큼 잘라낸 문자열
            val prefix = str1.substring(0, divisorLength)

            // 의사코드 5. 함수 isDivisor(문자열 s, 잠재적 약수 t)
            fun isDivisor(s: String, t: String): Boolean {
                // 의사코드 6. 만약 s가 t로 시작하지 않으면, 거짓(false) 반환
                if (!s.startsWith(t)) {
                    return false
                }
                // 의사코드 7. 임시 문자열 temp_s 초기화 (빈 문자열)
                // 의사코드 8. while temp_s의 길이 < s의 길이:
                // 의사코드 9. temp_s에 t를 이어붙이기
                // 코틀린 기능 활용: buildString, repeat
                val tempS = buildString { // 변수 이름 카멜 케이스 적용: temp_s -> tempS
                    repeat(s.length / t.length) {
                        append(t)
                    }
                }
                // 의사코드 10. 만약 temp_s와 s가 같다면, 참(true) 반환
                return tempS == s // 변수 이름 카멜 케이스 적용: temp_s -> tempS
                // 의사코드 11. 아니면, 거짓(false) 반환
            }

            // 의사코드 12. 만약 isDivisor(str1, prefix) 가 참이고 isDivisor(str2, prefix) 가 참이면
            if (isDivisor(str1, prefix) && isDivisor(str2, prefix)) {
                // 의사코드 13. prefix 반환  // 가장 큰 공통 약수 찾음
                return prefix
            }
        }

        // 의사코드 14. 반복문이 끝났지만 공통 약수를 찾지 못함: 빈 문자열 "" 반환
        return ""
    }
}