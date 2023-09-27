# 피보나치 수 2

n = int(input())

memo = [0] * (n + 1)

memo[1] = 1;

for i in range(n - 1):
    memo[i + 2] = memo[i + 1] + memo[i]

print(memo[n])