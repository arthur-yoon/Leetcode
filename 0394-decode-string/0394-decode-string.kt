import java.util.ArrayDeque
import java.lang.StringBuilder

class Solution {
    fun decodeString(s: String): String {
        val countStack = ArrayDeque<Int>()       // 숫자 스택 (반복 횟수 저장)
        val stringStack = ArrayDeque<StringBuilder>() // 문자열 스택 (이전 디코딩 문자열 저장)
        var currentString = StringBuilder()     // 현재 디코딩 문자열
        var currentNumber = 0               // 현재 숫자 (반복 횟수)

        for (char in s) {                      // for-each 루프 사용 (indices 대신)
            if (char.isDigit()) {
                currentNumber = currentNumber * 10 + char.digitToInt()
            } else if (char == '[') {
                countStack.addLast(currentNumber)          // 숫자 스택에 현재 숫자 push
                stringStack.addLast(currentString)         // 문자열 스택에 현재 문자열 push
                currentNumber = 0                     // 숫자 초기화
                currentString = StringBuilder()         // 문자열 초기화
            } else if (char == ']') {
                val repeatTimes = countStack.removeLast()     // 숫자 스택에서 반복 횟수 pop
                val previousString = stringStack.removeLast() // 문자열 스택에서 이전 문자열 pop
                for (i in 0 until repeatTimes) {           // until 사용 (코틀린 스타일 반복문)
                    previousString.append(currentString)    // 이전 문자열에 현재 문자열 반복 추가
                }
                currentString = previousString             // 현재 문자열 업데이트 (이전 문자열 + 반복된 현재 문자열)
            } else { // isLetter(char)
                currentString.append(char)              // 현재 문자열에 문자 추가
            }
        }
        return currentString.toString()                 // 최종 결과 문자열 반환 (StringBuilder -> String 변환)
    }
}