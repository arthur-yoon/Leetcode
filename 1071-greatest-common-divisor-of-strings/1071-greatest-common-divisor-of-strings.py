class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        # 정답문자열
        result = ''

        # 각 문자열 길이
        n1 = len(str1)
        n2 = len(str2)

        # 더 짧은 문자열 길이
        shorter_len = min(n1, n2)  

        # divides 함수
        def divides(s: str, t: str) -> bool:

            if len(s) % len(t) != 0:
                return False
            repeat_count = len(s) // len(t)
            constructed_s = ""
            for _ in range(repeat_count):
                constructed_s += t
            return constructed_s == s

        # 가능한 접두사 길이 (shorter_len 부터 1까지 내림차순) 만큼 반복
        for length in range(shorter_len, 0, -1):
            potential_divisor = str1[:length] # 접두사 후보 (str1에서 추출)

            # potential_divisor 가 str1과 str2를 모두 나누는지 확인
            if divides(str1, potential_divisor) and divides(str2, potential_divisor):
                return potential_divisor # 공약수 문자열 발견 (가장 긴 것부터 찾았으므로 최대 공약수)
        
        # 공약수 문자열을 찾지 못한 경우, 빈 문자열 반환
        return result 