#!/usr/bin/env python
#-*- coding: utf-8 -*-


def yazdir(sayi):
    n = ''
    for i in sayi:
        n += str(i)
    print n


def hex_to_bin(sayi):
    if type(sayi) != type("a"):
        print "string türünde sayıları giriniz ve \n\
gireceğiniz sayıda harf varsa onları büyük harfle giriniz."
    else:
        hex_sayi = {"A": 10, "B": 11, "C": 12, "D": 13, "E": 14, "F": 15}
        bin_sayi = []
        sayi = sayi[::-1]
        for i in sayi:
            if i not in hex_sayi:
                i = int(i)
                for j in range(0, 4):
                    k = i % 2
                    bin_sayi.append(k)
                    i = i / 2
            else:
                i = hex_sayi[i]
                for j in range(0, 4):
                    k = i % 2
                    bin_sayi.append(k)
                    i = i / 2
        yazdir(bin_sayi[::-1])


def oct_to_bin(sayi):
    if type(sayi) != type("a"):
        print "string türünde sayılar giriniz."
    else:
        bin_sayi = []
        sayi = sayi[::-1]
        for i in sayi:
            i = int(i)
            if int(i) >= 8:
                print "sayıyı string türünde ve octal sayı sistemine \n\
uygun olarak giriniz."
                break
            else:
                for j in range(0, 3):
                    k = i % 2
                    bin_sayi.append(k)
                    i = i / 2
        yazdir(bin_sayi[::-1])
