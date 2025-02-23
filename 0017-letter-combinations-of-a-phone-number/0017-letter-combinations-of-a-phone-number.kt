class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val result = mutableListOf<String>()
        val digitsLength = digits.length
        fun dfs(i: Int, current: String) {
            if (i >= digitsLength) {
                result.add(current)
                return
            }
            val mappedLetters = map.getValue(digits[i]) ?: ""
            for (letter in mappedLetters) {
                dfs(i + 1, current + letter)
            }
        }

        dfs(0, "")
        return result
    }
}

val map = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
)