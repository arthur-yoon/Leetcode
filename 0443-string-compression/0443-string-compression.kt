class Solution {
    fun compress(chars: CharArray): Int {
        if (chars.isEmpty()) {
            return 0
        }

        var read = 0
        var write = 0

        while (read < chars.size) {
            val currentChar = chars[read]
            var count = 0

            // Count consecutive repeating characters
            while (read < chars.size && chars[read] == currentChar) {
                read++
                count++
            }

            // Append the character
            chars[write++] = currentChar

            // Append the count if it's greater than 1
            if (count > 1) {
                val countStr = count.toString()
                for (charDigit in countStr) {
                    chars[write++] = charDigit
                }
            }
        }
        return write
    }
}