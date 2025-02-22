class SmallestInfiniteSet() {
    private var currentMin = 1
    private val minHeap = PriorityQueue<Int>() // 최소 힙 PriorityQueue

    fun popSmallest(): Int {
        return if (minHeap.isEmpty()) currentMin++ // 힙이 비어있으면 currentMin 반환 후 증가
        else minHeap.poll() // 힙이 비어있지 않으면 힙에서 poll
    }

    fun addBack(num: Int) {
        if (num < currentMin && !minHeap.contains(num)) { // 중복 체크 추가
            minHeap.add(num)
        }
    }
}