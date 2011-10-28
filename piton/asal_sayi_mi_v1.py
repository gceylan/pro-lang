#!/usr/bin/env python
#-*- coding: utf-8 -*-


def asal_mi(sayi):
    """
      >>> asal_mi(347777)
      Asal sayı değildir.
      En küçük böleni : 457
      >>> asal_mi(1345357)
      Asal sayı değildir.
      En küçük böleni : 13
      >>> asal_mi(456457)
      Asal sayıdır.
    """             # bellek kapasiteniz yüksek ise
                    # şunu bi deneyin asal_mi(123234347)
    s = []
    bolenler = []
    if sayi > 1:
        if sayi == 2:
            print "Asal sayıdır."
        elif sayi % 2 == 0:  # asal çift sayı = 2
            print "Asal sayı değildir.\nEn küçük böleni : 2"
        else:
            while True:
                for i in range(3, sayi, 2):
                    if sayi % i == 0:   # asal değildir.
                        s.append(0)
                        bolenler.append(i)
                    else:               # asaldır.
                        s.append(1)
                if 0 not in s:
                    print "Asal sayıdır."
                else:
                    print "Asal sayı değildir."
                    print "En küçük böleni :", bolenler[0]
                break
    else:
        print "Asal sayı değildir."
if __name__ == "__main__":
    import doctest
    doctest.testmod()
