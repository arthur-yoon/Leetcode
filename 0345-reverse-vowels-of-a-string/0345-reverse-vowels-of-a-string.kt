class Solution {
    fun reverseVowels(s: String): String {
        val charArray = s.toCharArray()

        var left = 0
        var right = charArray.size - 1

        while (left < right) {
            while (left < right && !isVowel(charArray[left])) {
                left++
            }
            while (left < right && !isVowel(charArray[right])) {
                right--
            }
            if (left < right) {
                charArray.swap(left, right)
                left++
                right--
            }
        }
        return String(charArray)
    }

    private fun isVowel(char: Char): Boolean {
        val vowels = "aeiouAEIOU"
        return char in vowels
    }

    private fun CharArray.swap(index1: Int, index2: Int) {
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }
}