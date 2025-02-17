class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        # 결과 문자열 초기화
        result = ""

        # 각 문자열의 길이
        len1, len2 = len(word1), len(word2)

        # 각 문자열의 공통길이
        common_len = min(len1, len2)

        # 공통길이만큼 번갈아가면서 문자 합치기
        for i in range(common_len):
            result += word1[i]
            result += word2[i]

        # 남은부분 처리
        if len1 > len2:
            result += word1[common_len:]
        elif len2 > len1:
            result += word2[common_len:]

        # 반환
        return result
