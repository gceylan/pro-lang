#!/usr/bin/env python
#-*- coding: utf-8 -*-


def liste_matris(m=matris, boyut=5):
    matris = {(0, 3): 1, (2, 1): 2, (4, 3): 3}
    matris2 = []
    n = 0
    while n != boyut:
        matris2.append([0] * boyut)
        n += 1
    for tup in matris:
        matris2[tup[0]][tup[1]] = matris[tup]
    return matris2
