#!/usr/bin/env python
#-*- coding: utf-8 -*-
import random
import string

def karisik_cumle(cumle):
    kelimeler = cumle.split()
    listem = []
    while len(kelimeler) != len(listem):
        index = random.randint(0, len(kelimeler))
        if kelimeler[index - 1] not in listem:
            listem.append(kelimeler[index - 1])
    karisik_cumle = string.join(listem, ' ')
    print karisik_cumle
