from typing import List

class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        planted_flowers = 0
        flowerbed_length = len(flowerbed)

        def is_left_plot_empty(flowerbed, index) -> bool:
            if index <= 0:
                return True
            else:
                return flowerbed[index-1] == 0

        def is_right_plot_empty(flowerbed, index) -> bool:
            if index >= flowerbed_length - 1:
                return True
            else:
                return flowerbed[index+1] == 0

        def is_plot_empty_and_adjacent_empty(flowerbed, index) -> bool:
            if flowerbed[index] == 1:
                return False
            else :
                return is_left_plot_empty(flowerbed, index) and is_right_plot_empty(flowerbed, index)

        for i in range(flowerbed_length):
            if is_plot_empty_and_adjacent_empty(flowerbed, i):
                flowerbed[i] = 1
                planted_flowers += 1
                if planted_flowers == n:
                    return True

        return planted_flowers >= n