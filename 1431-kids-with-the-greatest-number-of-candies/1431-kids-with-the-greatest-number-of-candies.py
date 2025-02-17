class Solution:
    def kidsWithCandies(self, candies: list[int], extraCandies: int) -> list[bool]:
        max_candies = max(candies)
        return [candy + extraCandies >= max_candies for candy in candies] # 리스트 컴프리헨션