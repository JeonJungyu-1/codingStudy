# 세 수
import sys

numbers = list(map(int, sys.stdin.readline().split()))

numbers.sort()

print(numbers[1])