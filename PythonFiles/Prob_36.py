import math

def binary(number):
    binary_list = []
    power_of_two = 0
    while math.pow(2, power_of_two) <= number:
        power_of_two += 1

    power_of_two -= 1
    num = number
    while power_of_two != -1:
        dif = math.pow(2, power_of_two)
        if dif <= num:
            binary_list.append(1)
            num -= dif
        else:
            binary_list.append(0)
        power_of_two -= 1
    return binary_list

def palindrome (number_list):
    if len(number_list) >= 2:
        if number_list[0] == number_list[len(number_list) - 1]:
            return palindrome(number_list[1:-1])
        return False
    return True

def decompose(number):
    list = []
    while number != 0:
        list.append(number % 10)
        number = int(number / 10)
    return list

LIMIT = int(math.pow(10, 6))

SUM = 0
palin = []
for x in range(1, LIMIT):
    if palindrome(decompose(x)):
        lis = binary(x)
        if palindrome(lis):
            print(x, lis)
            SUM += x
            palin.append(x)

print(len(palin), SUM)