# Only when the numbers on the LHS of the expression contain a total of 5
# digits is it possible to create a number on the RHS that has 4 digits. This
# is important as the expression must contain a total of 9 digits in order to
# be pandigital.

RES = []

def pandigital(list_one, list_two, list_three):
    result_one = shared_elements(list_one, list_three)
    if result_one == False:
        return False

    result_two = shared_elements(list_two, list_three)
    if result_two == False:
        return False

    return True

def shared_elements(list_one, list_two):
    freq_map = [0]*10
    for l in list_one:
        freq_map[l]+=1
        if freq_map[l] > 1:
            return False

    for l in list_two:
        freq_map[l]+=1
        if freq_map[l] > 1:
            return False

    if freq_map[0] > 0:
        return False

    return True

# Iterates through all X * XXXX products
for int_one in range(1, 10):
    for int_two in range(1000, 10000):
        l_one = list(map(int, str(int_one)))
        l_two = list(map(int, str(int_two)))

        multiply = shared_elements(l_one, l_two)
        if multiply:
            int_three = int_one * int_two
            l_three = list(map(int, str(int_three)))
            result = pandigital(l_one, l_two, l_three)
            if result:
                if int_three not in RES: RES.append(int_three)

# Iterates through all XX * XXX products
for int_one in range(11, 100):
    for int_two in range(100, 1000):
        l_one = list(map(int, str(int_one)))
        l_two = list(map(int, str(int_two)))

        multiply = shared_elements(l_one, l_two)
        if multiply:
            int_three = int_one * int_two
            l_three = list(map(int, str(int_three)))
            result = pandigital(l_one, l_two, l_three)
            if result:
                if int_three not in RES: RES.append(int_three)

SUM = 0
for num in RES:
    SUM+=num

print("THE SOLUTION IS: ", SUM)