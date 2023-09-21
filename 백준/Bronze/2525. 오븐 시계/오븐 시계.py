# 오븐시계

import sys

A, B = map(int, input().split())
C = int(input())

A += (B + C) // 60
A %= 24
B = (B + C) % 60

print(f"{A} {B}")