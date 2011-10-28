#!/usr/bin/env python
# -*- coding: utf-8 -*-

listem = [[1, 2, 3], 9, [4, 5]]
liste_sayisi = 0
for i in listem:
    if type(i) == list:
        liste_sayisi += 1
print liste_sayisi, "tane liste var"
