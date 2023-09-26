# Bucket Brigade

from collections import deque

arr = [[] for _ in range(10)]

for i in range(10):
    arr[i] = list(input())


start = []
end = []

for i in range(10):
    for j in range(10):
        if arr[i][j] == "B":
            start = [i, j]
        if arr[i][j] == "L":
            end = [i, j]


dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]

def bfs():
    que = deque()
    visited = [[False] * 10 for _ in range(10)]
    visited[start[0]][start[1]] = True
    que.append([start[0], start[1], 0])


    while que:
        r, c, cnt = que.popleft()

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < 10 and 0 <= nc < 10:
                if visited[nr][nc] or arr[nr][nc] == "R":
                    continue
                if nr == end[0] and nc == end[1]:
                    print(cnt)
                    que.clear()
                    break
                visited[nr][nc] = True

                que.append([nr, nc, cnt + 1])


bfs()