def factorial (n):
    if n > 1:
        return n * factorial(n-1)
    else:
        return 1

fracOneHund = factorial(100)
sum = 0
while fracOneHund:
    sum += fracOneHund % 10
    fracOneHund //= 10

print sum