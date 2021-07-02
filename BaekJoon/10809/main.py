
alphabet = [-1] * 28


if __name__ == '__main__':
    input_string = input()
    result = ''
    word = [c for c in input_string]
    num = 0
    for c in word:
        index = ord(c) - ord('a')
        if alphabet[index] == -1:
            alphabet[index] = num
        num += 1

    for i in range(0,26):
        result += str(alphabet[i])
        result += ' '
    print(result)

