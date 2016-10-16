MAX_DIGITS = 5000

def first_index(num, num_list):
    index = 0
    for n in num_list:
        if num == n:
            return index
        index += 1
    return -1

def gen_digits(number):
    counter = 0
    cycle_start = -1
    cycle_start_nought = -1
    cycle_end = -1
    dividen = 10

    num_list = []
    while counter != MAX_DIGITS:
        mult = int(dividen/number)
        dividen = (dividen - (number*mult))*10

        if cycle_start < 0:
            index = first_index(mult, num_list)
            if index > -1:
                cycle_start = index
                cycle_start_nought = index
                cycle_end = counter
        else:
            if cycle_start == cycle_end:
                return (cycle_end - cycle_start_nought)
            elif num_list[cycle_start+1] == mult:
                cycle_start += 1
            else:
                cycle_start = -1
                cycle_start_nought = -1
                cycle_end = -1
        num_list.append(mult)
        counter += 1
    return -1

cycle_length = 0
cycle_number = 0
no_cycle_list = []

for x in range(1, 1000):
    n = gen_digits(x)
    if n > cycle_length:
        cycle_number = x
        cycle_length = n
    elif n == -1:
        no_cycle_list.append(x)

print(cycle_length, cycle_number, no_cycle_list)