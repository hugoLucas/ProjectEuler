# Algorithm based on sieve of Eratosthenes. Sieve is important as rotations of a number can now simply
# be checked as prime by verifying the element at the value of the number minus two (sieve starts as two)
# is not zero. If it is zero then the rotation is not prime.

import math

INTERVAL = math.pow(10, 6)

def decompose(number):
    list = []
    while number != 0:
        list.insert(0, number % 10)
        number = int(number / 10)
    return list

def evaluate(number_list):
    value = 0
    size = len(number_list)
    for x in range(0, size):
        value += number_list[size - 1 - x] * math.pow(10, x)
    return int(value)

def rotate(number):
    number_list = decompose(number)
    return_list = []
    for x in range(0, len(number_list) - 1):
        first_digit = number_list[0]
        number_list.pop(0)
        number_list.append(first_digit)
        return_list.append(evaluate(number_list))
    return_list.append(number)
    return return_list

def set_all_zero(sieve_ref, num_list):
    for n in num_list:
        if sieve_ref[n - 2] != 0:
            sieve_ref[n - 2] = 0

sieve = list(range(2, int(INTERVAL)))

for x in range(2, int(math.sqrt(INTERVAL))):
    for i in range(x - 2, len(sieve), x):
        if sieve[i] % x == 0 and x != sieve[i]:
            sieve[i] = 0

COUNT = 0
for s in sieve:
    if s != 0:
        rot_list = rotate(s)
        zero_flag = False
        for r in rot_list:
            if sieve[r-2] == 0:
                zero_flag = True
                break
        if zero_flag == True:
            set_all_zero(sieve, rot_list)
        else:
            COUNT += 1

print(COUNT)