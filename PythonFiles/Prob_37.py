# Adding condition non-zero condition to sieve generation loop dramatically reduces
# execution time!

import math

START = 2
INTERVAL = math.pow(10, 6)
sieve = list(range(START, int(INTERVAL)))

length = len(sieve)
for x in range(2, int(math.sqrt(INTERVAL))):
    for i in range(x - START, length, x):
        if sieve[i] != 0:
            if sieve[i] % x == 0 and x != sieve[i]:
                sieve[i] = 0

SUM = 0
for s in sieve:
    if s != 0 and s > 10:
        trunc_flag = True
        # Check right to left truncations
        current_num = s
        while current_num != 0:
            if sieve[current_num - START] == 0:
                trunc_flag = False
                break
            current_num = int(current_num / 10)
        # Check left to right truncations
        current_num = s
        if trunc_flag:
            power_of_ten = 1
            while math.pow(10, power_of_ten + 1) <= current_num:
                power_of_ten += 1
            while power_of_ten != 0:
                current_num = int(current_num % math.pow(10, power_of_ten))
                if sieve[current_num - START] == 0:
                    trunc_flag = False
                    break
                power_of_ten -= 1
        # Display number if truncatable prime
        if trunc_flag:
            SUM += s

print("The answer is: ", SUM)