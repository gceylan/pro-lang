#!/usr/bin/env python
#-*- coding: utf-8 -*-


def ters_arama(sozluk, deger):
    n = sozluk.values()
    if deger not in n:
        print 'indeks bulunamadı.'
    for i in sozluk:
        if sozluk[i] == deger:
            print i
