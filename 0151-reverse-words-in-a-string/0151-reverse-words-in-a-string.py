class Solution:
    def reverseWords(self, s: str) -> str:
        # s_list
        words = s.split()
        
        # s_list 뒤집고
        words.reverse()
        
        # 공백으로 연결
        return " ".join(words)