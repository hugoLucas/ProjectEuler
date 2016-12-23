# Brute force approach, iterate through all possible combinations of two digit numerator
# and denominator fractions

# Determines if list share a common element value and returns that value
# Used to determine if two numbers share a digit
def common_number(d_list, n_list):
    for d_num in d_list:
        for n_num in n_list:
            if d_num == n_num:
                return n_num

    return -1

numerator = 1
denominator = 1

for denom in range(10,100):
    for numer in range(10,100):
        # If two numbers are equal then the result becomes trivial (i.e. 21 / 21 = 1/1)
        if denom != numer:
            d_list = list(map(int, str(denom)))
            n_list = list(map(int, str(numer)))
            c_n = common_number(d_list, n_list)
            if c_n > 0:
                d_list.remove(c_n)
                n_list.remove(c_n)

                # Avoids divide by 0 error
                if d_list[0] != 0 and n_list[0] != 0:
                    val = n_list[0]/d_list[0]
                    if val == numer/denom and val < 1:
                        numerator *= numer
                        denominator *= denom

print(numerator, "/", denominator)