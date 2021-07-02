
if __name__ == '__main__':
    input_values = input().split(' ')
    a = int(input_values[0])
    b = int(input_values[1])
    c = int(input_values[2])
    input_int = [a, b, c]
    input_int.sort()
    print(input_int[1])
