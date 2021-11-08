#by Maryam Sadat Safavi
for _ in range(int(input())):
    data = []
    answ = 0
    for _ in range(int(input())):
        lttr, prc = input().split()
        data.append(lttr)
        data.append(prc)
    for _ in range(int(input())):
        sntc = input()
        for i in range(0, len(data), 2):
            if i == 0 or i % 2 == 0:
                answ += int(sntc.count(data[i])*(int(data[i+1])))
    print("{:.2f}".format(answ/100), end='$\n')
