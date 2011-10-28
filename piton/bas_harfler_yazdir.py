#!/usr/bin/env python
#-*- coding: utf-8 -*-
def bas_harfler_yazdir(cumle, isaret='.'):
    kelimeler = cumle.split()
    sonuc = ""
    for kelime in kelimeler:
        sonuc = sonuc + (kelime[0] + isaret)
    print sonuc

bas_harfler_yazdir("Türkiye Büyük Millet Meclisi")
bas_harfler_yazdir("Türkiye Büyük Millet Meclisi", '')
