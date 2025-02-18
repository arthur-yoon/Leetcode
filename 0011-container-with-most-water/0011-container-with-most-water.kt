import kotlin.math.min
import kotlin.math.max

class Solution {
    fun maxArea(height: IntArray): Int {
        var maxWater = 0 // 최대 넓이 초기화
        var left = 0 // 왼쪽 포인터 초기화
        var right = height.size - 1 // 오른쪽 포인터 초기화

        while (left < right) {
            val currentHeight = min(height[left], height[right]) // 현재 높이 (짧은 선 기준)
            val currentWidth = right - left // 현재 너비 (두 포인터 거리)
            val currentWater = currentHeight * currentWidth // 현재 넓이
            maxWater = max(maxWater, currentWater) // 최대 넓이 갱신

            if (height[left] < height[right]) { // 왼쪽 선이 더 짧으면
                left++ // 왼쪽 포인터 오른쪽으로 이동 (더 긴 선을 찾아서 높이 증가 기대)
            } else { // 오른쪽 선이 더 짧거나 같으면
                right-- // 오른쪽 포인터 왼쪽으로 이동 (더 긴 선을 찾아서 높이 증가 기대)
            }
        }
        return maxWater // 최대 넓이 반환
    }
}