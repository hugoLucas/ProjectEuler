def divisorList(n):
    list = []
    for x in xrange(1,(n/2)+1):
        if n % x == 0:
            list.append(x)
    return list

amicableList = []
for x in xrange(1,10001):
    sumOne = sum(divisorList(x))
    sumTwo = sum(divisorList(sumOne))
    if x == sumTwo and sumOne != sumTwo:
        if x not in amicableList:
            amicableList.append(x)
        elif sumOne not in amicableList:
            amicableList.append(sumOne)

print sum(amicableList)