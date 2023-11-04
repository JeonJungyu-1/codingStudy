# 대소문자 바꾸기

str = input()

for i in range(len(str)):
    if 65 <= ord(str[i]) <= 90:
        print(chr(ord(str[i]) + 32), end="")
    else:
        print(chr(ord(str[i]) - 32), end="")