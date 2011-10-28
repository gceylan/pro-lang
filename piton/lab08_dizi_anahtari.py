def dizi_anahtari(sayi):
    str_liste = sayi.split('-')
    int_liste = []
    for i in str_liste:
        int_liste.append(int(i))
    int_liste.sort()
    n = len(int_liste)
    a, b = 0, 0
    for i in int_liste:
        a += i
    if n % 2 == 0:
        b = (int_liste[n / 2] + int_liste[(n / 2) - 1]) / 2

    else:
        b = int_liste[n / 2]
    return (a / n) * b

