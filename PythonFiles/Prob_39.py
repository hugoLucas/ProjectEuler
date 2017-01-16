import math

per_count = [0]*1000

for a in range(1, 1000):
    for b in range(a + 1, 1000 - a + 1):
        c = math.sqrt(math.pow(a,2) + math.pow(b,2))
        if c % 1 == 0:
            p = int(a + b + c)
            if p <= 1000:
                per_count[p-1] += 1

perimeter = 0
perimeter_count = -1
for i in range(0, len(per_count)):
    if per_count[i] > perimeter_count:
        perimeter_count = per_count[i]
        perimeter = i + 1

print(perimeter_count, perimeter)