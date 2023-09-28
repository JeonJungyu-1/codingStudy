# 분산처리
import sys

T = int(input())


for _ in range(T):
    a, b = map(int, input().split())
    result = 1
    while b:
        if b & 1:
            result = (result * a) % 10
        a = (a * a) % 10
        b >>= 1

    if result == 0:
        result = 10
    print(result)