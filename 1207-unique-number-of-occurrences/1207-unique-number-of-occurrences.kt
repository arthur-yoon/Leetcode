// sol_1 : 성능우선
// class Solution {
//     fun uniqueOccurrences(arr: IntArray): Boolean {
//         val valueOccurrencesMap = HashMap<Int, Int>()

//         for (num in arr) {
//             valueOccurrencesMap[num] = (valueOccurrencesMap.get(num) ?: 0) + 1
//         }

//         val valueOccurrencesSet = HashSet<Int>()
//         for (occurences in valueOccurrencesMap.values) {
//             if (valueOccurrencesSet.contains(occurences)) {
//                 return false
//             }
//             valueOccurrencesSet.add(occurences)
//         }
//         return true
//     }
// }

// sol_2 : 코틀린스럽게
class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val frequencyMap = arr.toList().groupingBy { it }.eachCount()
        val frequencySet = HashSet<Int>(frequencyMap.values)
        return frequencySet.size == frequencyMap.size
    }
}