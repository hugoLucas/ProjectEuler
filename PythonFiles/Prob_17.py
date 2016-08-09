# More efficient algorithm is possible by determining the instances of each digit for
# all numbers under 1000 and then multiplying by the letter count of the digit (keeping
# in mind to add 3 for each instance of "and"). I chose this implementation to help
# me learn Python so it will not be the most efficient. Rather it will be the version
# I think will help me learn more about the language.
# Created by: Hugo Flores J. Lucas 8/5/2015

s1 = "one"
s11 = "eleven"
s12 = "twelve"
s13 = "thirteen"
s15 = "fifteen"
s10 = "teen"
s10n = "ten"
s2 = "two"
s20 = "twenty"
s3 = "three"
s30 = "thirty"
s4 = "four"
s40 = "forty"
s5 = "five"
s50 = "fifty"
s6 = "six"
s60 = "sixty"
s7 = "seven"
s70 = "seventy"
s8 = "eight"
s80 = "eighty"
s9 = "nine"
s90 = "ninety"
s100 = "hundred"
sAnd = "and"

singleDigits = [s1,s2,s3,s4,s5,s6,s7,s8,s9]
doubleDigitPrefixes = [s10, s20, s30, s40, s50, s60, s70, s80, s90]

doubleDigits = []
for x in xrange(0,10):
    if x == 0:
        doubleDigits.append(s10n)
    elif x == 1:
        doubleDigits.append(s11)
    elif x == 2:
        doubleDigits.append(s12)
    elif x == 3:
        doubleDigits.append(s13)
    elif x == 5:
        doubleDigits.append(s15)
    else:
        doubleDigits.append(singleDigits[x-1] + s10)

for x in xrange(1, 9):
    for j in xrange(0, 10):
        if j == 0:
            doubleDigits.append(doubleDigitPrefixes[x])
        else:
            doubleDigits.append(doubleDigitPrefixes[x]+singleDigits[j-1])

oneThrough99 = singleDigits + doubleDigits

hundreds = []
for y in xrange(0, 9):
    hundreds.append(singleDigits[y] + s100)
    for x in xrange(0,99):
        hundreds.append(singleDigits[y] + s100 + sAnd + oneThrough99[x])

masterList = oneThrough99 + hundreds
masterList.append("onethousand")

print masterList

length = 0
for y in xrange(0, 1000):
    length += len(masterList[y])

print length