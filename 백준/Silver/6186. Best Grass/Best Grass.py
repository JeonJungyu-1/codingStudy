# Best Grass

import sys
from collections import deque

dr = [0, -1, 0, 1]
dc = [-1, 0, 1, 0]

N, M = map(int, input().split())

arr = [list(input()) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
cnt = 0


def isInRange(r, c):
    return 0 <= r < N and 0 <= c < M


def bfs(i, j):
    que = deque()
    que.append([i, j])
    while que:
        r, c = que.pop()
        if arr[r][c] == ".":
            break

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if not isInRange(nr, nc):
                continue
            if visited[nr][nc] or arr[nr][nc] == '.':
                continue
            visited[nr][nc] = True
            que.append([nr, nc])


for i in range(N):
    for j in range(M):
        if visited[i][j] or arr[i][j] == ".":
            continue
        visited[i][j] = True
        bfs(i, j)
        cnt += 1



print(cnt)