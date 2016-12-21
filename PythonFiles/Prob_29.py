# Going to try brute-force method before something clever.

a_range = list(range(2,101))
b_range = list(range(2,101))

unique = []
for x in a_range:
    for y in b_range:
        num = pow(x,y)
        if num not in unique:
            unique.append(num)

print(len(unique))

# Brute force works surprisingly fast. Need to figure out a way to compute result
# faster and without so many computations of large powers.