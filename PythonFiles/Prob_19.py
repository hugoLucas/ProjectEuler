def monthLimit(currentMonth, currentYear):
    if currentMonth == 'Feb':
        if currentYear % 4 == 0:
            if currentYear % 100 == 0:
                if currentYear % 400 == 0:
                    return 29
                else:
                    return 28
            else:
                return 29
        else:
            return 28

        return 29
    elif currentMonth == 'Sept' or currentMonth == 'Apr' or currentMonth == 'Jun' or currentMonth == 'Nov':
        return 30
    else:
        return 31

daysOfTheWeek = ['Mon', 'Tues', 'Wed', 'Thurs', 'Fri', 'Sat', 'Sun']
monthsOfTheYear = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec']
currentYear = 1900
sundayCount = 0

currentDayName = 0
while currentYear < 2001:
    currentMonth = 0
    while currentMonth < 12:
        currentDayNum = 1
        currentMonthLimit = monthLimit(monthsOfTheYear[currentMonth], currentYear)
        while currentDayNum <= currentMonthLimit:
            if daysOfTheWeek[currentDayName] == 'Sun' and currentDayNum == 1:
                if currentYear != 1900:
                    sundayCount += 1
            currentDayName = (currentDayName + 1)% 7
            currentDayNum += 1
        currentMonth += 1
    currentYear+=1

print sundayCount
