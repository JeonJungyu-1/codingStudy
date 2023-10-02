# 알고리즘 수업 - 피보나치 수 1

N = int(input())

memo = [0] * (N + 1)

a = 0
b = 0


def fib(n):
    if n == 1 or n == 2:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)


def fibonacci(n):
    global b
    memo[1] = memo[2] = 1
    for i in range(3, n + 1):
        b += 1
        memo[i] = memo[i - 1] + memo[i - 2]
    return memo[n]



a = fibonacci(N)

print(f'{a} {b}')