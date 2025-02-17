class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # 전체 길이
        len_nums = len(nums)
        
        # 배열 결과 초기화
        answer = [1] * len_nums

        # prefix 곱 계산 answer 에 저장하기
        prefix_init = 1
        for i in range(len_nums):
            answer[i] = prefix_init
            prefix_init *= nums[i]

        # suffix 곱 배열 answer 에 저장하기
        suffix_init = 1
        for i in range(len_nums -1, -1, -1):
            answer[i] *= suffix_init
            suffix_init *= nums[i]

        # 결과 반환
        return answer