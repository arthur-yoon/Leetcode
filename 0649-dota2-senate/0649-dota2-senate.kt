class Solution {
    fun predictPartyVictory(senate: String): String {
        val radiantQueue: ArrayDeque<Int> = ArrayDeque()
        val direQueue: ArrayDeque<Int> = ArrayDeque()
        val n = senate.length

        for (i in 0 until n) {
            if (senate[i] == 'R') {
                radiantQueue.addLast(i)
            } else {
                direQueue.addLast(i)
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            val radiantSenatorIndex = radiantQueue.removeFirst()
            val direSenatorIndex = direQueue.removeFirst()

            if (radiantSenatorIndex < direSenatorIndex) {
                radiantQueue.addLast(radiantSenatorIndex + n)
            } else {
                direQueue.addLast(direSenatorIndex + n)
            }
        }

        return if (radiantQueue.isNotEmpty()) "Radiant" else "Dire"
    }
}