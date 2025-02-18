class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0

        flowerbed.forEachIndexed { index, isPlanted ->
            if (isPlanted == 0) {
                val isLeftEmpty = (index == 0) || (flowerbed[index - 1] == 0)
                val isRightEmpty = (index == flowerbed.size - 1) || (flowerbed[index + 1] == 0)

                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[index] = 1
                    count++
                    if (count >= n) {
                        return true
                    }
                }
            }
        }
        return count >= n
    }
}