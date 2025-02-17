# 요건 정리
# i_value < j_value < k_value
class Solution:
    
    def increasingTriplet(self, nums: List[int]) -> bool:
        # 초기값 세팅
        i_value = float('inf')
        j_value = float('inf')

        # nums 순회
        for num in nums:
            # 현재값 <= i_value -> i_value = 현재값
            if (num <= i_value):
                i_value = num
            # 현재값 <= j_value -> j_value = 현재값
            elif (num <= j_value):
                j_value = num
            # 현재값 > j_value -> true
            else:
                return True
        # false
        return False