# ROT13

str = list(map(ord, input()))



for i in range(len(str)):
    if 65 <= str[i] <= 90:
        str[i] += 13
        if str[i] >= 91:
            str[i] -= 26
    elif 97 <= str[i] <= 122:
        str[i] += 13
        if str[i] >= 123:
            str[i] -= 26

print("".join(list(map(chr, str))))