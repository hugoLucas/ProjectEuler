# Limit interval to 9,999 as any 5 digit number times two will result in at least another 5 digit
# number which will make it impossible for the concatenation of the number and its product to be
# pandigital. If there are 10 digits, one must be zero or a repeat which will void the condition.

def repeat_digits(number):
    count = [0] * 10
    while number != 0:
        digit = number % 10
        number = int(number / 10)
        if count[digit] != 0:
            return True
        else:
            count[digit] += 1
    return False

for num in range(2, 9999):
    if not repeat_digits(num):
        current_num = num
        count_list = [0] * 10
        void_flag = False
        mult = 2
        concat_list = []
        while not void_flag:
            concat_list.append(current_num)
            while current_num != 0:
                digit = current_num % 10
                current_num = int(current_num / 10)
                if count_list[digit] == 0:
                    count_list[digit] += 1
                else:
                    void_flag = True
                    break
            if count_list[0] == 1:
                void_flag = True
            if not void_flag and sum(count_list) == 9:
                print(num, concat_list)

            current_num = num * mult
            mult += 1