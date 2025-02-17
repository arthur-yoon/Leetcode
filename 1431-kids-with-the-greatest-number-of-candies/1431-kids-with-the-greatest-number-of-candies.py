
class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        # 결과값 저장 배열 초기화
        result = [False] * len(candies)
        
        # 최대 캔디를 구하고
        max_candies = max(candies)

        # 각 아이에게 추가 캔디를 줄때 최대값 이상인지
        for i in range(len(candies)):
            # 추가캔디를 줌
            max_candies_this_kid = candies[i] + extraCandies
            
            # 가장 많은 캔디 이상판단
            if max_candies_this_kid >= max_candies:
                result[i] = True
        # 결과값 반환
        return result