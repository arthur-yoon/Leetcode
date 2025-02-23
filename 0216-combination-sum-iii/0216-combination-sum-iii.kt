class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()

        fun backtrack(remainCount: Int, remainSum: Int, startNum: Int) {
            if (remainCount == 0 && remainSum == 0) { // 조건만족
                result.add(combination.toList())
                return
            }

            if (remainCount < 0 || remainSum < 0) { // 유효하지 않음
                return
            }

            for (i in startNum .. 9) {
                combination.add(i)
                backtrack(remainCount - 1, remainSum - i, i + 1)
                combination.removeLast()
            }
        }

        backtrack(k, n, 1)
        return result
    }
}

// 1~9
// 1회 사용
// k 개 숫자 사용
// 합이 n
// 중복조합 x
