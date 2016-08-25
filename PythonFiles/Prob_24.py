# Algorithm depends on the fact that all numbers starting with 0 will be less than those with 1 and those are less than
# numbers starting with 2. Thus if calculate the amount of numbers possible given the first is already set, we know which
# number on the list of possible numbers is going to be in the front since we can subtract that number from the ordering
# needed. Applying this contionusly until the list of numbers is empty gives us the 1mil-th number.

import math

lexorder = 1000000

possInts = []
for x in xrange(10):
    possInts.append(x)

lex = []
while len(possInts) != 0:
    if len(possInts) == 1:
        lex.append(possInts[0])
        possInts.remove(possInts[0])
    else:
        fac = math.factorial(len(possInts)-1)
        index = 0
        while lexorder > fac:
            lexorder = lexorder - fac
            index = index + 1
        lex.append(possInts[index])
        possInts.remove(possInts[index])

num = 0
pow = 0
for x in xrange(len(lex)-1,-1,-1):
    num += lex[x]*math.pow(10,pow)
    pow += 1

print num