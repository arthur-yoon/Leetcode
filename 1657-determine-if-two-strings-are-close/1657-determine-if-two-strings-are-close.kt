class Solution {
    // 길이체크
    // 
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }

        val word1CharSet = word1.toSet()
        val word2CharSet = word2.toSet()
        if (word1CharSet != word2CharSet) {
            return false
        }

        val word1FrequencyMap = word1.groupingBy { it }.eachCount()
        val word2FrequencyMap = word2.groupingBy { it }.eachCount()

        val word1Frequencies = word1FrequencyMap.values.sorted()
        val word2Frequencies = word2FrequencyMap.values.sorted()

        return word1Frequencies == word2Frequencies

    }
}