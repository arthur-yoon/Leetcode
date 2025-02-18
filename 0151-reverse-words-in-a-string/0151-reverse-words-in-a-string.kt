import kotlin.text. CharCategory

class Solution {
    fun reverseWords(s: String): String {
        val trimmedString = s.trim()
        val wordsList = trimmedString.split(whitespace = true) // 확장 함수 split(whitespace = true) 사용

        val reversedWordsList = wordsList.reversed()
        return reversedWordsList.joinToString(" ")
    }
}

// CharSequence split 확장 함수 (whitespace 옵션 추가)
fun CharSequence.split(whitespace: Boolean = false): List<String> {
    return if (whitespace) {
        this.split("\\s+".toRegex()) // whitespace=true 인 경우, 정규 표현식 사용 (복수 공백, 다양한 whitespace 처리)
    } else {
        this.split(" ") // whitespace=false (기본값) 인 경우, 기존 split(" ") 사용 (단일 공백 구분 - 필요에 따라 다른 기본 동작 정의 가능)
    }
}