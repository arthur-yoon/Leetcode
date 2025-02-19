class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var currentAltitude = 0
        var largestAltitude = 0

        for (altitude in gain) {
            currentAltitude += altitude
            largestAltitude = maxOf(largestAltitude, currentAltitude)
        }
        return largestAltitude
    }
}