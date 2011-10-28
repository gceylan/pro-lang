#!/usr/bin/env python
#-*- coding: utf-8 -*-


def histogram(kar_dizisi):
    kontrol = ''
    for harf in kar_dizisi:
        if harf not in kontrol:
            kontrol += harf
    for i in kontrol:
        s = 0
        for j in range(len(kar_dizisi)):
            if i == kar_dizisi[j]:
                s += 1
        print i, ':', s
