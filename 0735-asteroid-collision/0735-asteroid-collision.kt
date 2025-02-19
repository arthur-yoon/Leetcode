class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val survivedAsteroidsDeque = mutableListOf<Int>()

        for (asteroid in asteroids) {
            if (asteroid > 0) {
                survivedAsteroidsDeque.add(asteroid) // push
            } else { // asteroid < 0
                while (survivedAsteroidsDeque.isNotEmpty() && survivedAsteroidsDeque.last() > 0 && survivedAsteroidsDeque.last() < abs(asteroid)) {
                    survivedAsteroidsDeque.removeLast() // pop
                }

                if (survivedAsteroidsDeque.isNotEmpty() && survivedAsteroidsDeque.last() > 0 && survivedAsteroidsDeque.last() == abs(asteroid)) {
                    survivedAsteroidsDeque.removeLast()
                } else if (survivedAsteroidsDeque.isEmpty() || survivedAsteroidsDeque.last() < 0) {
                    survivedAsteroidsDeque.add(asteroid)
                }
            }
        }

        // ArrayDeque -> List -> IntArray 로 변환 (toIntArray() 바로 사용 불가)
        return survivedAsteroidsDeque.toIntArray()
    }
}