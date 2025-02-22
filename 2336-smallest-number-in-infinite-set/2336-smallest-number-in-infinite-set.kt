import java.util.PriorityQueue

class SmallestInfiniteSet() {
    private val minHeap: PriorityQueue<Int> = PriorityQueue()
    private var currentSmallestPositiveInteger = 1

    fun popSmallest(): Int {
        println("popSmallest() 호출 시작 - 현재 상태: minHeap=$minHeap, currentSmallestPositiveInteger=$currentSmallestPositiveInteger") // 로그 시작

        if (minHeap.isNotEmpty()) {
            val smallestFromHeap = minHeap.peek()
            println("minHeapNotEmpty: smallestFromHeap=$smallestFromHeap") // 로그: 힙이 비어있지 않음
            if (smallestFromHeap <= currentSmallestPositiveInteger) {
                val poppedValue = minHeap.poll()
                println("힙에서 pop: $poppedValue") // 로그: 힙에서 pop 발생
                println("popSmallest() 반환: $poppedValue,  상태 변경: minHeap=$minHeap, currentSmallestPositiveInteger=$currentSmallestPositiveInteger") // 로그 반환 및 상태
                return poppedValue
            } else {
                println("힙 최소값(${smallestFromHeap}) > currentSmallestPositiveInteger(${currentSmallestPositiveInteger}), currentSmallestPositiveInteger 반환") // 로그: 힙 최소값 > currentSmallestPositiveInteger
            }
        } else {
            println("minHeapEmpty: 힙이 비어있음") // 로그: 힙이 비어있음
        }

        val smallest = currentSmallestPositiveInteger
        currentSmallestPositiveInteger++
        println("기본 값 pop: $smallest, 상태 변경: minHeap=$minHeap, currentSmallestPositiveInteger=$currentSmallestPositiveInteger") // 로그: 기본 값 pop
        println("popSmallest() 호출 종료 - 반환 값: $smallest") // 로그 종료
        return smallest
    }

    fun addBack(num: Int) {
        println("addBack($num) 호출 시작 - 현재 상태: minHeap=$minHeap, currentSmallestPositiveInteger=$currentSmallestPositiveInteger") // 로그 시작
        if (num < currentSmallestPositiveInteger) {
            minHeap.offer(num)
            println("minHeap에 $num 추가 - 상태 변경: minHeap=$minHeap, currentSmallestPositiveInteger=$currentSmallestPositiveInteger") // 로그: 힙에 추가
        } else {
            println("addBack($num) 조건 불만족 (num >= currentSmallestPositiveInteger), minHeap 변경 없음") // 로그: 조건 불만족
        }
        println("addBack($num) 호출 종료 - 상태: minHeap=$minHeap, currentSmallestPositiveInteger=$currentSmallestPositiveInteger") // 로그 종료
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */