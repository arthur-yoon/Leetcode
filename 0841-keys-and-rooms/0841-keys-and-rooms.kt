class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n: Int = rooms.size
        val visited = BooleanArray(n) { false }
        val queue: LinkedList<Int> = LinkedList()
        var visitedRoomCount = 0
        queue.add(0)
        visited[0] = true
        visitedRoomCount++

        while (queue.isNotEmpty()) {
            val currentRoom = queue.removeFirst()
            val keys = rooms[currentRoom]

            for (key in keys) {
                if (!visited[key]) {
                    visited[key] = true
                    visitedRoomCount++
                    queue.addLast(key)
                }
            }
        }
        return visitedRoomCount == n
    }
}