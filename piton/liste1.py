#!/usr/bin/env python
# -*- coding: utf-8 -*-

kelimeler = ["merhaba", "benim", "adim", "gkhan"]
sesliler = "aeiouAEIOU"
sesli_sayisi = 0

for index, kelime in enumerate(kelimeler):
    for harf in kelime:
        if harf in sesliler:
            sesli_sayisi += 1
    print kelimeler[index], ":", "sesli sayısı :", sesli_sayisi
    sesli_sayisi *= 0
    
