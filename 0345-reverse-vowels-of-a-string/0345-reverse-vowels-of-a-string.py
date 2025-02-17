class Solution:
    def reverseVowels(self, s: str) -> str:
        # 모음판단
        vowels = set('aeiouAEIOU')
        
        # 모음_list : 문자열에서 나온 모음 그대로 저장 리스트
        vowels_list = []
        
        # 모음_index_list: 문자열에서 나온 모음의 index 저장 리스트
        vowels_index_list = []

        # 문자열 순회
        for i, char in enumerate(s):
            #모음과 인덱스를 찾기
            if char in vowels:
                # 리스트에 모음과 해당 모음의 인덱스 저장
                vowels_list.append(char)
                vowels_index_list.append(i)
        
        # 모음_list 뒤집기
        vowels_list.reverse()

        # 원본문자열을 리스트로 변환
        s_list = list(s)

        # 모음_index_list 순회
        for i in range(len(vowels_index_list)):
            # 원본문자열의 index 문자에 모음
            s_list[vowels_index_list[i]] = vowels_list[i]

        # 반환 list to str
        return "".join(s_list)