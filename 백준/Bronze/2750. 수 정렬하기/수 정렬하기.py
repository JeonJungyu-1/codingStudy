# 수 정렬하기
import sys

n = int(input())

numbers = []

for _ in range(n):
    numbers.append(int(sys.stdin.readline()))


numbers.sort()

for i in range(n):
    print(numbers[i])