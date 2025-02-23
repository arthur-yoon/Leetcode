class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        // 1. 결과 문자열을 저장할 merged_string
        val mergedString = StringBuilder()
        
        // 2. word1과 word2의 현재 인덱스를 나타내는 변수 i와 j를 0으로 초기화한다.
        var i = 0
        var j = 0

        // 3. i가 word1의 길이보다 작고 j가 word2의 길이보다 작은 동안 반복한다.
        while (i < word1.length && j < word2.length) {
            mergedString.append(word1[i]) // word1[i]를 merged_string에 추가한다.
            mergedString.append(word2[j]) // word2[j]를 merged_string에 추가한다.
            // i와 j를 1씩 증가시킨다.
            i++
            j++
        }

        // 4. 만약 i가 word1의 길이보다 작다면 (word1에 남은 문자가 있다면), word1[i]부터 word1의 끝까지 merged_string에 추가한다.
        while (i < word1.length) {
            mergedString.append(word1[i])
            i++
        }

        // 5. 만약 j가 word2의 길이보다 작다면 (word2에 남은 문자가 있다면), word2[j]부터 word2의 끝까지 merged_string에 추가한다.
        while (j < word2.length) {
            mergedString.append(word2[j])
            j++
        }

        // 6. merged_string을 반환한다.
        return mergedString.toString()
    }
}