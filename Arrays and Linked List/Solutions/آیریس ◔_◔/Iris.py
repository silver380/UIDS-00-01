#by Adrina Ebrahimi
t = int(input())

while t:
    n = int(input())
    arr = list(map(int, input().split()))
    maximum = arr.pop(arr.index(max(arr)))
    sum_arr = sum(arr)
    if sum_arr - maximum in arr:
        arr.remove(sum_arr - maximum)
        print(' '.join(map(str, sorted(arr))))
        
    else:
        print(-1)   
    t -= 1