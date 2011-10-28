def maks_sayi(dizgi):
    maks = ''
    en_buyuk = 0
    for sayi in dizgi:
        n = max(dizgi)
        maks += n
        m = dizgi.index(n)
        dizgi = dizgi[:m] + dizgi[m+1:]
    return maks

