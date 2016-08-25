import string

sourceFile = open("C:\\Users\\Hugo Lucas\\PycharmProjects\\Project Euler\\namesProb22.txt")


# Split file into individual names and remove the quotation marks around them
list = sourceFile.read().split(",")
for i in xrange(len(list)):
    list[i] = list[i][1:-1]

list.sort()

# Go through each name and calculate its score. Put score in second list.
listPrime = []
for i in xrange(len(list)):
    currentSum = 0
    for j in xrange(len(list[i])):
        l = list[i][j].lower()
        currentSum += string.lowercase.index(l) + 1
    listPrime.append(currentSum)

# Calculate total sum of the product of the name score and its position in the list
retSum = 0
for i in xrange(len(listPrime)):
    retSum += listPrime[i] * (i + 1)

print retSum