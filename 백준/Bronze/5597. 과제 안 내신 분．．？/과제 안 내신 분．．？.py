# 과제 안 내신 분

visited = [False for _ in range(31)]


for _ in range(28):
    visited[int(input())] = True


for i in range(1, 31):
    if not visited[i]:
        print(i)