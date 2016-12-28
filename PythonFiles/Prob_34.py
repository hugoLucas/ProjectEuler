# Upper limit is set to 2,540,160. Derivation of limit: the number 9,999,999 (7 nines)
# yields the factorial sum of 2,540,160. However the number 999,999 (6 nines) yields the
# factorial sum 2,177,280. Once the number of digits exceeds 7, it is impossible for the
# factorial sum to match the value of the number.

import math

def decompose(number):
    list = []
    while number != 0:
        list.append(number % 10)
        number = int(number / 10)
    return list

factorial_list = []
for x in range(0,10):
    factorial_list.append(math.factorial(x))

ANSEWER = 0
for num in range(3, 2540160):
    sum = 0
    for x in decompose(num):
        sum += factorial_list[x]
    if sum == num:
        ANSEWER += num

print("The answer is: ", ANSEWER)