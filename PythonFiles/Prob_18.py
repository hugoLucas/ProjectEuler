#The algoritm for this problem is as follows: copy the last line of the triangle to an array. Next,
#iterate through every line and every element. For every element, determine the maximum sum that element
#can produce with its two adjacent neighbors on the lower level, or in our case the array of the previous
#line, and store that number. Once all elements have been iterated through for a given line, replace the
#previous line's array with the new array of sums.

from sys import argv

triList = []
numOfLines = 15
txt = open("triangleProb18.txt", "r")

# Reads text file with triangle and turns it into a list of lists
for i in xrange(0,numOfLines):
    triList.append(txt.readline().split())

# maxList will represent the previous line's list
maxList = []
for l in reversed(triList):

    # For the first iteration we must use the last line of the array
    if len(l) == numOfLines:
        maxList = maxList + l
    else:
        # newMaxList will store the maximum sum possible for each element
        newMaxList = []

        # This loop determines the maximum sum possible for a given element and its "lower" two
        # neighbors in the traingle. For every line of the traingle the number of iterations
        # decreases by 1.
        for i in xrange(0,len(l)):
            newMaxList.append(int(l[i]) + max(int(maxList[i]), int(maxList[i+1])))
        maxList = newMaxList

# Should print out the maximum sum possible
print(maxList)