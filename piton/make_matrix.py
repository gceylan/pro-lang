#!/usr/bin/env python
#-*- coding: utf-8 -*-
def make_matrix(tekrar, liste_tekrar):
    d = [0]
    sonuc = []
    while len(sonuc) != tekrar:
        sonuc.append(d * liste_tekrar)
    return sonuc
