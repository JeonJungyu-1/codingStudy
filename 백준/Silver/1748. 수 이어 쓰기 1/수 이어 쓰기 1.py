# 수 이어 쓰기 1

N = int(input())

cnt = 0

number = 100000000

while number > 0:
    if N >= number:
       cnt += (N - number) * len(str(number)) + 1
       N = number
    number //= 10



print(cnt)