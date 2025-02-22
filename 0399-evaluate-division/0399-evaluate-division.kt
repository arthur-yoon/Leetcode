class Solution {
    data class RatioInfo(val variable: String, val ratio: Double) // 데이터 클래스 정의

    private fun bfs(adj: HashMap<String, HashMap<String, Double>>, startVar: String, endVar: String): Double {
        if (!adj.containsKey(startVar) || !adj.containsKey(endVar)) { // 변수 존재 여부 체크
            return -1.0
        }
        if (startVar == endVar) { // 자기 자신 쿼리 처리
            return 1.0
        }

        val queue: LinkedList<RatioInfo> = LinkedList()
        val visited = HashSet<String>()
        queue.addLast(RatioInfo(startVar, 1.0))
        visited.add(startVar)

        while (queue.isNotEmpty()) {
            val currentRatioInfo = queue.removeFirst()
            val currentVar = currentRatioInfo.variable
            val currentRatio = currentRatioInfo.ratio

            if (currentVar == endVar) {
                return currentRatio // 비율 찾음
            }

            val neighbors = adj[currentVar] ?: continue

            for (neighbor in neighbors.entries) {
                val neighborVar = neighbor.key
                val weight = neighbor.value
                if (!visited.contains(neighborVar)) {
                    visited.add(neighborVar)
                    queue.addLast(RatioInfo(neighborVar, currentRatio * weight))
                }
            }
        }
        return -1.0 // 경로 못 찾음
    }


    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        // 1. Build Graph (Adjacency List)
        val adj = HashMap<String, HashMap<String, Double>>()
        for (i in equations.indices) {
            val equation = equations[i]
            val value = values[i]
            val var1 = equation[0]
            val var2 = equation[1]

            adj.computeIfAbsent(var1) { HashMap() }[var2] = value
            adj.computeIfAbsent(var2) { HashMap() }[var1] = 1.0 / value
        }

        // 2. Process Queries using BFS (함수 호출)
        val results = DoubleArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val startVar = query[0]
            val endVar = query[1]
            results[i] = bfs(adj, startVar, endVar) // BFS 함수 호출
        }
        return results
    }
}