#This problem was asked by Snapchat.

#Given an array of time intervals (start, end)
#for classroom lectures (possibly overlapping),
#find the minimum number of rooms required.

#For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

def min_intervals(intervals):
    intervals.sort(key=lambda i:i[0])
    count = 0
    for i in range(1, len(intervals)):
        if intervals[i][0] < intervals[i-1][-1]:
            count+=1
    return count

intervals = [(30, 75), (0, 50), (60, 150)]
print min_intervals(intervals)
            
