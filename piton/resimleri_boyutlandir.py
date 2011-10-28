#!/usr/bin/env python
#-*- coding: utf-8 -*-

import os
from Image import *


# isterseniz boyutları siz belirleyin...
def boyutlandir_v1(kaynak_dizin, resim_formati, w, h):
    depo_adi = "depo"
    depo = os.mkdir(depo_adi)
    yol = os.getcwd()
    for i in os.listdir(kaynak_dizin):
        isim = os.path.splitext(i)
        resim = open(kaynak_dizin + "/" + i)
        yeni_resim = resim.resize((w, h))
        yeni_resim.save(yol + "/" + depo_adi + "/" + isim[0] + resim_formati)
    print "Tamamlandı."


# oranları koruyarak resimleri büyültüp küçültebilirsiniz...
def boyutlandir_v2(kaynak_dizin, resim_formati, oran):
    for i in os.listdir(kaynak_dizin):
        isim = os.path.splitext(i)
        resim = open(kaynak_dizin + "/" + i)
        w, h = resim.size       # türü tuple
        yeni_resim = resim.resize((w * oran, h * oran))
        yeni_resim.save("/home/gokhan/Masaüstü/" + isim[0] + resim_formati)
    print "Tamamlandı."
