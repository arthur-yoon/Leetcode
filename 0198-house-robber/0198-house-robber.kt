import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0 // 집이 0개인 경우 예외 처리: 훔칠 금액 0
        if (n == 1) return nums[0] // 집이 1개인 경우 예외 처리: 첫 번째 집 금액 반환

        // DP 테이블 크기를 입력 배열 크기보다 1 크게 설정 (인덱스 0부터 n까지 사용)
        val dp = IntArray(n + 1)

        // Base Case 1: dp[0] = 0
        dp[0] = 0
        // Base Case 2: dp[1] = nums[0] 첫 번째 집까지 훔칠 수 있는 최대 금액은 첫 번째 집의 돈
        dp[1] = nums[0]

        // 점화식: dp[i] = max(dp[i-2] + nums[i-1], dp[i-1]) (for i >= 2)
        // i번째 집까지 최대 금액은,
        // 1. i번째 집을 털 경우: dp[i-2] + nums[i-1] (이전 집(i-1)은 털 수 없으므로 i-2번째 집까지 최대 금액 + 현재 집 금액)
        // 2. i번째 집을 털지 않을 경우: dp[i-1] (이전 집(i-1)까지 최대 금액)
        // 위 두 경우 중 최대값을 선택
        for (i in 2..n) { // i는 1-based 인덱스 (1번째 집, 2번째 집, ..., n번째 집)
            dp[i] = max(dp[i - 2] + nums[i - 1], dp[i - 1]) // nums 배열은 0-based 인덱스 사용 (nums[i-1])
        }

        // 최종 결과 반환: dp[n] (n번째 집까지 고려했을 때 최대 금액)
        return dp[n]
    }
}

// 인접한 집을 같은날밤에 털면 시큐리티발동
// dp[i] = max(dp[i-2] + nums[i-1], dp[i-1]) (for i >= 2)
// dp[1] = nums[0] = 1
// dp[2] = max(nums[0], nums[1]) = max(1, 2) = 2
// dp[3] = max(dp[3-2] + nums[3-1], dp[3-1]) = max(dp[1] + nums[2], dp[2])