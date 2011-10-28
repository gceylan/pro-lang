def seslileri_at_sondan_basa_yaz(dizgi):
    sesliler = "aeiouAEIOU"
    yeni_dizgi = ''
    for harf in dizgi:
        if harf in sesliler:
            yeni_dizgi += "_"
        else:
            yeni_dizgi += harf
    n = len(yeni_dizgi)
    while 0 < n:
        print yeni_dizgi[n - 1],
        n -= 1

        
    
