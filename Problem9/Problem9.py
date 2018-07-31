#This problem was asked by Airbnb.

#Given a list of integers, write a function that returns the largest
#sum of non-adjacent numbers. Numbers can be 0 or negative.
#For example, [2, 4, 6, 2, 5] should return 13, since
#we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

def largest_non_adjacent(arr):
    if len(arr) <= 2:
        return max(0, max(arr))

    cached_result = [0] * len(arr)
    cached_result[0] = max(0, arr[0])
    cached_result[1] = max(cached_result[0], arr[1])

    for i in range(2, len(arr)):
        num = arr[i]
        cached_result[i] = max(num + cached_result[i - 2], cached_result[i - 1])
    return cached_result[-1]

l = [2, 4, 6, 2, 5]
print largest_non_adjacent(l)

