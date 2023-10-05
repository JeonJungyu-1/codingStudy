# 성 지키기

N, M = map(int, input().split())

arr = [list(input()) for _ in range(N)]

cnt = 0

r = N
c = M



for i in range(N):
    for j in range(M):
        if arr[i][j] == "X":
            r -= 1
            break



for j in range(M):
    for i in range(N):
        if arr[i][j] == "X":
            c -= 1
            break

result = 0
if N == 1:
    result = c
elif M == 1:
    result = r
else:
    result = r if r > c else c

print(result)