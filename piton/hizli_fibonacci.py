#!/usr/bin/env python
#-*- coding: utf-8 -*-
import doctest


def hizLi_fibonacci(n):
    """
      >>> hizLi_fibonacci(7)
      13
      >>> hizLi_fibonacci(11)
      89
      >>> hizLi_fibonacci(19)
      4181
      >>> hizLi_fibonacci(0)
      0
      >>> hizLi_fibonacci(-7)
      Lutfen pozitif bir tamsayi giriniz.
      >>> hizLi_fibonacci(12.7)
      Lutfen pozitif bir tamsayi giriniz.
    """
    if n < 0 or type(n) != type(5):
        print "Lutfen pozitif bir tamsayi giriniz."
    else:
        sonuclar = {0: 0, 1: 1, 2: 1, 3: 2, 4: 3, 5: 5, 6: 8, 7: 13, 8: 21,
                    9: 34, 10: 55}
        if n in sonuclar:
            return sonuclar[n]
        else:
            return hizLi_fibonacci(n - 1) + hizLi_fibonacci(n - 2)
doctest.testmod()
