# 평균은 넘겠지
import sys

T = int(input())

for _ in range(T):
    numbers = list(map(int, sys.stdin.readline().split()))
    sumNumber = sum(numbers[1:])
    avg = sumNumber/numbers[0]

    cnt = 0
    for number in numbers[1:]:
        if number > avg:
            cnt += 1

    print(f"{round(cnt / numbers[0] * 100, 3)}%")