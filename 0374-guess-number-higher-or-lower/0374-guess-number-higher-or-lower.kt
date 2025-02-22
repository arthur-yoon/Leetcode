/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        var low = 1
        var high = n

        while (true) {
            val mid = low + (high-low) / 2
            val result = guess(mid)

            if (result == 0) {
                return mid
            } else if (result == -1) {
                high = mid - 1
            } else { // result == 1
                low = mid + 1
            }
        }
    }
}