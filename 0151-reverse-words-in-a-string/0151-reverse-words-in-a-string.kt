class Solution {
    fun reverseWords(s: String): String {
        // 의사코드 2. 입력 문자열 s 의 leading/trailing 공백 제거 (trim)
        val trimmedString = s.trim()

        // 의사코드 3. 문자열 s 를 공백(whitespace) 기준으로 단어 리스트로 분할 (split, 복수 공백 처리, 빈 문자열 제거)
        val wordsList = trimmedString.split("\\s+".toRegex()) // 정규표현식 "\\s+" 를 사용하여 공백(whitespace) 기준으로 분할, 복수 공백 처리

        // 의사코드 4. 단어 리스트를 역순으로 정렬 (reverse)
        val reversedWordsList = wordsList.reversed() // 컬렉션 기능 활용: reversed

        // 의사코드 5. 역순으로 정렬된 단어 리스트를 단일 공백으로 연결하여 문자열 생성 (joinToString)
        return reversedWordsList.joinToString(" ") // 컬렉션 기능 활용: joinToString, 단일 공백 " " 을 구분자로 사용
    }
}