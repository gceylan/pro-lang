#!/usr/bin/python
# -*- coding: utf-8 -*-
import random


# matrisi elle girmemek için bir fonksiyon
def rastgeleMatrisUret(satir=10, sutun=10):
    matris = []

    for i in range(0, satir):
        araMatris = []
        for j in range(0, sutun):
            n = random.randint(0, 255)
            araMatris.append(n)
        matris.append(araMatris)

    return matris


def matrisEsikle(matris, duyarlilik):
    print "rastgele matris", matris

    #len(matris) = satir sayisina denk
    for i in range(0, len(matris)):
        # len(matris[0]) = sutun sayisina denk
        for j in range(0, len(matris[0])):
            if matris[i][j] < duyarlilik:
                matris[i][j] = 0
            else:
                matris[i][j] = 1

    print "son hali"
    return matris

# 3 satir 4 sütunluk matris üretelim ve fonksiyona gonderelim
m = rastgeleMatrisUret(3, 4)
print matrisEsikle(m, 128)
