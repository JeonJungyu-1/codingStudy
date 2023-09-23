# 알고리즘 수업 - 너비 우선 탐색 1


from collections import deque
import sys
input = sys.stdin.readline

N, M, R = map(int, input().split())

adj = [[] for _ in range(N + 1)]

for _ in range(M):
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)

visited = [0] * (N + 1)

for i in range(N + 1):
    adj[i].sort()


def bfs(R):
    count = 1
    visited[R] = count

    que = deque()
    que.append(R)
    while que:
        cur = que.popleft()
        for n in adj[cur]:
            if visited[n] == 0:
                count += 1
                visited[n] = count
                que.append(n)


bfs(R)

for i in range(1, N + 1):
    print(visited[i])