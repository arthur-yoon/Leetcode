class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIndex = 0
        var tIndex = 0

        while (sIndex < s.length && tIndex < t.length) {
            if (s[sIndex] == t[tIndex]) { // s[sIndex] 와 t[tIndex] 가 같으면
                sIndex++ // sIndex 증가 (s 의 다음 문자 확인)
            }
            tIndex++ // tIndex 는 항상 증가 (t 문자열 순회)
        }

        return sIndex == s.length
    }
}