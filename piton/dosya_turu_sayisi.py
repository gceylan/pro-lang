#!/usr/bin/env python
#-*- coding: utf-8 -*-

import os


def dosya_turu(metin):
    x = metin[::-1].find(".")
    L = len(metin)
    metin = metin[::-1][:x + 1]
    return metin[::-1]


def dosya_turu_sayisi(tur='.py', yol='/home/gokhan'):
    t = 0
    for i in os.walk(yol):
        print i
        for j in i[2]:
            if dosya_turu(j) == tur:
                t += 1
    print yol, 'dizini ve alt dizinlerindeki', tur, '\
uzantılı dosya sayısı:', t
dosya_turu_sayisi()
dosya_turu_sayisi('.c')
dosya_turu_sayisi('.html')
dosya_turu_sayisi('.png')
