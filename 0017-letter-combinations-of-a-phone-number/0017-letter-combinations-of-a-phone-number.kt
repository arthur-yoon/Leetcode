class Solution {
    private val letterOfDigit = mapOf(
        '2' to "abc".toList(),
        '3' to "def".toList(),
        '4' to "ghi".toList(),
        '5' to "jkl".toList(),
        '6' to "mno".toList(),
        '7' to "pqrs".toList(),
        '8' to "tuv".toList(),
        '9' to "wxyz".toList(),
    )

    private fun List<String>.combine(letters: List<Char>): List<String> =
        letters.flatMap { c -> this.map { it + c } }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        var res = listOf<String>("")
        for (digit in digits) {
           res = res.combine(letters = letterOfDigit.getOrDefault(digit, listOf()))
        }
        return res
    }
}