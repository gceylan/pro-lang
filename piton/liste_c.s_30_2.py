def sondan_basa_yaz_listem():
    listem = [1, 2, 3, 4, 5]
    sonuc = []
    n = len(listem)
    while 0 < n:
        sonuc.append(listem[n - 1])
        n -= 1
    print sonuc
