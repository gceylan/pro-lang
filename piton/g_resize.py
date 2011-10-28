#!/usr/bin/env python
#-*- coding: utf-8 -*-

import os
from Image import *


# isterseniz boyutları siz belirleyin...
def g_img_resize(dizin_yolu, tur, w, h):
    print '-' * 20 + ' işlem başlatıldı ' + '-' * 20
    depo = os.system('mkdir gdepo')

    for yol, dizinler, dosyalar in os.walk(dizin_yolu):
        for dosya in dosyalar:
            img_name, turu = os.path.splitext(dosya)
            print yol, '-------->', dosya
            if yol[-1] != '/':
                yol = yol + '/'
            try:
                img = open(yol + dosya)
                new_img = img.resize((w, h))
                new_img.save(os.getcwd() + '/' + 'gdepo/new_' + img_name + tur)
            except:
                pass

    print '-' * 20 + ' işlem tamamlandı ' + '-' * 20
    print 'resimler "gdepo" dizinindedir.'
#g_img_resize('/home/gokhan/Resimler', '.png', 1280, 800)


# oranları koruyarak resimleri büyültüp küçültebilirsiniz...
def g_img_resize(dizin_yolu, tur, oran):
    print '-' * 20 + ' işlem başlatıldı ' + '-' * 20
    depo = os.system('mkdir gdepo')
    turler = [".png", ".jpg", ".jpeg", ".gif", ".bmp", ".tiff", ".tif"]

    for yol, dizinler, dosyalar in os.walk(dizin_yolu):
        for dosya in dosyalar:
            img_name, turu = os.path.splitext(dosya)
            if yol[-1] != '/':
                yol = yol + '/'
            try:
                img = open(yol + dosya)
                if turu in turler:
                    print yol, '---------->', dosya
                    w, h = img.size
                    new_img = img.resize((w * oran, h * oran))
                    new_img.save(os.getcwd() + '/' + 'gdepo/new_' + img_name + tur)
            except:
                pass

    print '-' * 20 + ' işlem tamamlandı ' + '-' * 20
    print 'resimler "gdepo" dizinindedir.'
#g_img_resize('/home/gokhan/Resimler', '.png', 0.5)
