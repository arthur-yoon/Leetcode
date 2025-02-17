class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        # 1. 공약수 문자열 존재 조건 확인
        if str1 + str2 != str2 + str1:
            return ""

        # 2. GCD 알고리즘의 문자열 적용 (반복적 축소)
        while str2: # str2가 비어있지 않은 동안 반복 (while str2 != "") 와 동일
            if len(str1) < len(str2):
                str1, str2 = str2, str1 # 파이썬 스타일의 swap

            str1 = str1[len(str2):] # str1에서 str2 길이만큼 prefix 제거

        # 3. 기저 조건: str2가 빈 문자열이 되면 str1 반환
        return str1