# There is only 1 way to make change for n pence using 1p coins. Using 2p coins, you can make change for n pence
# anywhere you can substitute two 1p coins for one 2p coin. Thus all solutions to make change for n - 2 using 1p
# coins are also valid using 2p coins. This same logic applies for 5p, 10p, etc...

coin_list = [2, 5, 10, 20, 50, 100, 200]
solution_array = [1] * 200

for coin in coin_list:
    for x in range(coin - 1, len(solution_array)):
        pence_value = x + 1

        if pence_value == coin:
            solution_array[x] += 1
        else:
            solution_array[x] += solution_array[x-coin]

print(solution_array)