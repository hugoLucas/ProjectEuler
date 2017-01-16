import math


def algo(index):
    power_of_ten, number_of_digits, numbers_in_range, total_digits = 0, 0, 0, 9
    prev_total_digits = 0
    if index > 9:
        while total_digits < index:
            power_of_ten += 1
            number_of_digits = power_of_ten + 1
            numbers_in_range = int(math.pow(10, power_of_ten + 1) - math.pow(10, power_of_ten))

            prev_total_digits = total_digits
            total_digits += (number_of_digits * numbers_in_range)
        index_remainder = index - prev_total_digits - 1
        numbers_between = seperation(index_remainder, number_of_digits)
        number_at_index = int(math.pow(10, power_of_ten) + numbers_between)
        index_remainder -= (numbers_between * number_of_digits)

        temp_map = decompose(number_at_index)
        return temp_map[index_remainder]
    else:
        return index


def decompose(number):
    list = []
    while number != 0:
        list.insert(0, number % 10)
        number = int(number / 10)
    return list


def seperation(diff, num_of_digits):
    num_sep = 0
    while diff - num_of_digits >= 0:
        num_sep += 1
        diff -= num_of_digits
    return num_sep

product = 1
for x in range(0, 7):
    index = int(math.pow(10, x))
    result = algo(index)
    print(index, '--->', result)
    product *= result
print('ANSWER: ', product)
