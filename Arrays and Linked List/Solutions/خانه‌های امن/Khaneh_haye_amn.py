#Kian Majlesi
n, m = map(int, input().split())
lsr, lsc = list(), list()

for __ in range(m):
    xi, yi = map(int, input().split())

    if not lsr.count(xi):
        lsr.append(xi)

    if not lsc.count(yi):
        lsc.append(yi)

    ans = (n ** 2) - (((n) * len(lsc)) + ((n-len(lsc)) * len(lsr)))
    print(ans if ans >= 0 else 0, end=' ')
