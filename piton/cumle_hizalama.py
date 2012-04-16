#!/usr/bin/python
# -*- coding: utf-8 -*-


# 80 satır uzunluğunda bir satır düşün. m cümlesi bu 80 satırın sağından
# hizalanmıştır.
def sagaHizala(metin, satir_uzunlugu):
    liste = [' '] * satir_uzunlugu
    ind = satir_uzunlugu - len(metin)

    for i in metin:
        liste[ind] = i
        ind += 1

    return ('').join(liste)

m = "merhaba ben gceylan"
print sagaHizala(m, 80)


def solaHizala(metin, satir_uzunlugu):
    liste = [' '] * satir_uzunlugu

    for i in range(len(metin)):
        liste[i] = metin[i]

    return ('').join(liste)

print solaHizala(m, 80)


# burada önemli nokta şu
# elimde 10 satır olsun bunun ortası 10 / 2 = 5
# elimdeki metin de "gceylan" olsun. bunun ortası 7 / 2 = 3
# yani benim listemin (5 - 3). elemanı metinimin yani "gceylan" ' ın ilk harfidir...
# bu şekilde metin ortalanabilir.
def ortaLa(metin, satir_uzunlugu):
    liste = [' '] * satir_uzunlugu

    liste_orta = satir_uzunlugu / 2
    metin_orta = len(metin) / 2

    for i in metin:
        liste[liste_orta - metin_orta] = i
        liste_orta += 1

    return ('').join(liste)

print ortaLa(m, 80)
