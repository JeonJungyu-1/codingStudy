# 부호
import sys

for _ in range(3):
    n = int(input())
    s = 0
    for _ in range(n):
        s += int(sys.stdin.readline())

    print(0 if s == 0 else "-" if s < 0 else "+")