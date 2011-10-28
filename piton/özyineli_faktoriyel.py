#!/usr/bin/env python
#-*- coding: utf-8 -*-


def faktoriyeL(n):
    if n < 0:
        print 'Negatif tamsayilarin faktoriyel hesaplamasi yapilamaz.'
        return
    elif n == 0 or n == 1:
        return 1
    else:
        return n * faktoriyeL(n - 1)
