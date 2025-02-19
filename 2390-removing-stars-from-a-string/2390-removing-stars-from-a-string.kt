import java.util.LinkedList

class Solution {
    fun removeStars(s: String): String {
        val stack = LinkedList<Char>()

        for (char in s) {
            if (char == '*') {
                if (stack.isNotEmpty()) {
                    stack.removeLast()
                }
            } else {
                stack.addLast(char)
            }
        }

        return stack.joinToString("")
    }
}