# 그대로 출력하기

while True:
    try:
        str = input()
        if str == '':
            break
        print(str)
    except EOFError:
        break