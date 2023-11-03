# 행렬 덧셈

N, M = map(int, input().split())

arr = [[] for i in range(N)]


for i in range(N):
    arr[i] = list(map(int, input().split()))

for i in range(N):
    lis = list(map(int, input().split()))
    for j in range(M):
        arr[i][j] += lis[j]


for i in range(N):
    for j in range(M):
        print(arr[i][j], end=" ")
    print("")