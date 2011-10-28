#!/usr/bin/env python
#-*- coding: utf-8 -*-

import os


def dosya_dizin_sayisi(dosya_yolu):
    dosya, dizin = 0, 0
    for i in os.listdir(dosya_yolu):
        if os.path.isdir(i) == True:
            dizin += 1
        else:
            dosya += 1
    print 'dizin sayısı :', dizin
    print 'dosya sayısı :', dosya
