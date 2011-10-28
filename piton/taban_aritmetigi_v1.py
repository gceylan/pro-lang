#!/usr/bin/env python
#-*- coding: utf-8 -*-


def duzenle_getir(sayi, n):
    sayi = str(sayi)
    sayi = sayi[::-1]
    x = list(sayi)
    y = len(x)
    z = y % n
    t = []
    for i in range(0, y - z, n):
        a = x[i:i + n]
        t.append(a)
    t.append(x[y - z:])
    return t


def yazdir(liste):
    sonuc = ""
    for i in liste:
        sonuc += str(i)
    return sonuc


def bin_to_oct(sayi):
    liste = duzenle_getir(sayi, 3)
    t = 0
    s = []
    for i in liste:
        if len(i) != 0:
            for j in range(0, len(i)):
                t += ((2 ** j) * int(i[j]))
        s.append(str(t))
        t = 0
    return int(yazdir(s[::-1]))


def bin_to_dec(sayi):
    sayi = str(sayi)
    liste = list(sayi[::-1])
    s = 0
    for i in range(0, len(liste)):
        s += ((2 ** i) * int(liste[i]))
    return s


def bin_to_hex(sayi):
    liste = duzenle_getir(sayi, 4)
    t = 0
    h = ['A', 'B', 'C', 'D', 'E', 'F']
    s = []
    for i in liste:
        if len(i) != 0:
            for j in range(0, len(i)):
                t += ((2 ** j) * int(i[j]))
            if t >= 10:
                s.append(h[t % 10])
            else:
                s.append(str(t))
            t = 0
    return yazdir(s[::-1])


def oct_to_bin(sayi):
    s = oct_to_dec(sayi)
    return dec_to_bin(s)


def oct_to_dec(sayi):
    sayi = str(sayi)
    liste = sayi[::-1]
    t = 0
    for i in range(0, len(liste)):
        t += (8 ** i) * int(liste[i])
    return t


def oct_to_hex(sayi):
    s = oct_to_dec(sayi)
    return dec_to_hex(s)


def dec_to_bin(sayi):
    s = []
    while sayi:
        k = sayi % 2
        s.append(k)
        sayi /= 2
    return int(yazdir(s[::-1]))


def dec_to_oct(sayi):
    s = dec_to_bin(sayi)
    return bin_to_oct(s)


def dec_to_hex(sayi):
    s = dec_to_bin(sayi)
    return bin_to_hex(s)


def hex_to_bin(sayi):
    s = hex_to_dec(sayi)
    return dec_to_bin(s)


def hex_to_oct(sayi):
    s = hex_to_dec(sayi)
    return dec_to_oct(s)


def hex_to_dec(sayi):
    sayi = str(sayi)
    liste = list(sayi[::-1])
    h = {"A": 10, "B": 11, "C": 12, "D": 13, "E": 14, "F": 15}
    t, sayac = 0, 0
    for i in liste:
        if i not in h:
            t += (16 ** sayac) * int(liste[sayac])
            sayac += 1
        else:
            t += (16 ** sayac) * h[i]
            sayac += 1
    return t
