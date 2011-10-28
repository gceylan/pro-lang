#!/usr/bin/env python
# -*- coding: utf-8 -*-

listem = [[1, 2, 3], [4, 5], [12]]
toplam = 0

for index, liste in enumerate(listem):
    for sayi in liste:
        toplam += sayi
    print "listem[", index, "] =", len(liste), "eleman,",\
    "toplam =", toplam
    toplam *= 0