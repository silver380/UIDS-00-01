#by Maryam Sadat Safavi
n = int(input())
lst = list(map(int, input().split()))[:n]
max =i =0
m=j =n-1
while(i>=0 and j>=0):
    if lst[i]<lst[j]:
        max=j-i
        break
    if (j==n-1):
        i=0
        m-=1
        j=m
    else:
        i+=1
        j+=1

if max==0: print("YOU DIED")
else: print(max)

