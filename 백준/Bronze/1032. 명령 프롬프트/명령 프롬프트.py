# 명령 프롬프트

N = int(input())


str = list(input())

for _ in range(N - 1):
    st = list(input())

    for i in range(len(str)):
        if str[i] != st[i]:
            str[i] = "?"



print("".join(str))