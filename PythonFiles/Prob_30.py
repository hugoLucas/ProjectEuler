import math

def digit_limit(power):
    dig_lim = 2
    eq_val = dig_lim * math.pow(9, power) - (math.pow(10, dig_lim-1) - 1)
    while eq_val > 0:
        dig_lim += 1
        eq_val = dig_lim * math.pow(9, power) - (math.pow(10, dig_lim-1) - 1)
    return dig_lim


def increment_list(l):
    place = len(l) - 1
    while True:
        l[place] += 1
        if l[place] == 10 and place != 0:
            l[place] = 0
            place -= 1
        elif l[place] < 10:
            return 1
        else:
            return 0

def s_list(l, powr):
    power_sum = 0
    arith_sum = 0

    plc = len(l)
    for a in l:
        power_sum += math.pow(a, powr)
        arith_sum += a * math.pow(10, plc - 1)
        plc -= 1
    return [power_sum, arith_sum]

power_to_investigate = 5
max_digits = digit_limit(power_to_investigate)

sum_list = [0] * max_digits
print "Maximum Digits: ", max_digits
while increment_list(sum_list) != 0:
    sums = s_list(sum_list, power_to_investigate)
    if sums[0] == sums[1]:
        print sums[1]
