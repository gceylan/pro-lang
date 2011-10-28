#!/usr/bin/env python
#-*- coding: utf-8 -*-
import os


def sezar_sifreLe(dosyam):
    ad = 'sezar_sifrelenmis.txt'
    olustur = os.system('touch' + ad)

    dosya1 = open(dosyam, 'r')
    dosya2 = open(ad, 'w')

    while True:
        oku = dosya1.readline(50)
        if oku == '':
            break
        else:
            for i in oku:
                n = ord(i)
                if n <= 119 or n <= 87:
                    dosya2.write(chr(n + 3))
                elif n > 199 or n > 87:
                    dosya2.write(chr(n - 23))
    dosya1.close()
    dosya2.close()
    return


def sezar_sifresi_coz(dosyam):
    ad = 'sezar_cozulmus.txt'
    olustur = os.system('touch' + ad)

    dosya1 = open(dosyam, 'r')
    dosya2 = open(ad, 'w')

    while True:
        oku = dosya1.readline(50)
        if oku == '':
            break
        else:
            for i in oku:
                n = ord(i)
                if i == '#':
                    dosya2.write(' ')
                elif n <= 99 or n <= 67:
                    dosya2.write(chr(n + 23))
                elif n > 99 or n > 67:
                    dosya2.write(chr(n - 3))
    dosya1.close()
    dosya2.close()
    return
