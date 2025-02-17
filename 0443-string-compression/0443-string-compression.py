# 추가공간을 쓰면 안된다면 제자리에서 수정해야하고 원본배열에서 대상을 훑어보고 압축된 데이터를 넣는다
class Solution:
    def compress(self, chars: List[str]) -> int:
        # 포인터 시작
        read_pointer = 0
        write_pointer = 0
        n = len(chars)

        # 전체탐색
        while (
            read_pointer < n
        ):  # 1. read_pointer가 배열 끝까지 순회하는 외부 while 루프
            current_char = chars[
                read_pointer
            ]  # 2. 현재 read_pointer가 가리키는 문자 current_char에 저장
            count = 0  # 3. 현재 문자 그룹의 반복 횟수 count 초기화

            while (
                read_pointer < n and chars[read_pointer] == current_char
            ):  # 4. 내부 while 루프: 동일 문자 연속 횟수 카운트
                count += 1  # 5. count 증가
                read_pointer += 1  # 6. read_pointer 전진 (다음 문자 읽기 위해)

            chars[write_pointer] = (
                current_char  # 7. 압축된 문자 current_char를 write_pointer 위치에 쓰기
            )
            write_pointer += (
                1  # 8. write_pointer 전진 (다음 압축 문자/숫자 쓸 위치 확보)
            )

            if count > 1:  # 9. 반복 횟수가 1보다 크면 숫자도 문자열로 변환하여 쓰기
                count_str = str(count)  # 10. 반복 횟수를 문자열로 변환
                for digit_char in count_str:  # 11. 숫자 문자열의 각 자리수 순회
                    chars[write_pointer] = digit_char  # 12. 숫자 문자 쓰기
                    write_pointer += (
                        1  # 13. write_pointer 전진 (다음 숫자 쓸 위치 확보)
                    )

        # 결과반환
        return write_pointer
