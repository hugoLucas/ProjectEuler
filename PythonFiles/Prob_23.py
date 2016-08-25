import gc
import math
LIMIT = 28123
# Find all abundant numbers under 28,123
abundNums = []
for x in xrange(12,LIMIT+1,1):
    s = 0
    range = int(math.sqrt(x)) + 1
    for j in xrange(1,range,1):
        if x % j == 0:
            s += j
            x_comp = x / j
            if x_comp != j and x_comp != x:
                s += x_comp
    if s > x:
        abundNums.append(x)

# Determine which numbers under 28,123 cannot be expressed as the sum of
# two abundant numbers
sum = ((LIMIT)*(LIMIT+1))/2
possSum = []
for x in xrange(len(abundNums)):
    for j in xrange(x,len(abundNums),1):
        s = abundNums[x] + abundNums[j]
        if s > LIMIT:
            break
        else:
            possSum.append(s)

newList = list(set(possSum))
for j in xrange(len(newList)):
    sum = sum - newList[j]

print sum
