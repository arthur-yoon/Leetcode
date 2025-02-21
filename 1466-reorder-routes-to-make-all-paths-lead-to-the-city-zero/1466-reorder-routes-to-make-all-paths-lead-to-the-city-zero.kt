class Solution {

    data class Road(val to: Int, val reversed: Boolean)

    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val roads = Array(n) { ArrayList<Road>() }
        for (road in connections) {
            roads[road[0]].add(Road(road[1], true))
            roads[road[1]].add(Road(road[0], false))
        }
    
        // bfs starts here
        val visited = BooleanArray(n)
        var reversed = 0

        val queue = LinkedList<Int>()
        queue.add(0)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val nextCity = queue.removeFirst()
                if (visited[nextCity]) continue
                visited[nextCity] = true

                roads[nextCity].forEach {
                    if (!visited[it.to]) {
                        queue.add(it.to)

                        // here we count roads
                        if (it.reversed) reversed++
                    }
                }
            }
        }
        return reversed
    }
}