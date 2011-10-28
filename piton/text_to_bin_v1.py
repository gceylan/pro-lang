#!/usr/bin/env python
# -*- coding: utf-8 -*-


def yazdir(liste):
    dizgi = ""
    for i in liste:
        dizgi += i
    print dizgi


def text_to_bin(metin):
    ascii = ""
    ascii_liste = []
    for i in metin:
        n = ord(i)
        while n:
            k = n % 2
            ascii += str(k)
            n /= 2
        L = len(ascii)
        if L != 8:
            ascii = ("0" * (8 - L)) + ascii[::-1]
        ascii_liste.append(ascii)
        ascii = ""
    yazdir(ascii_liste)


def bin_to_text(bin_sayi):
    if type(bin_sayi) != str:
        print "string türünde binary sayı giriniz..."
    else:
        text = ''
        t = 0
        L = len(bin_sayi)
        for i in range(0, L, 8):
            sayi = bin_sayi[i: i + 8]
            sayi = sayi[::-1]
            for j in range(0, len(sayi)):
                t += (2 ** j) * int(sayi[j])
            text += chr(t)
            t = 0
        print text

text_to_bin("gceylan")
bin_to_text("010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001")
bin_to_text("01100111011000110110010101111001011011000110000101101110")
