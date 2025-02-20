class RecentCounter(val requestQueue: ArrayDeque<Int> = ArrayDeque<Int>()) {

    fun ping(t: Int): Int {
        requestQueue.addLast(t)
        while (requestQueue.isNotEmpty() && requestQueue.first() < t - 3000) {
            requestQueue.removeFirst()
        }
        return requestQueue.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */