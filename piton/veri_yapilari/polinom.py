# -*- coding: utf-8 -*-


#gceylan
def eleman_sayilarini_esitle(liste1, liste2, yer, eleman):
    n = len(liste1)
    m = len(liste2)
    while n != m:
        if n > m:
            liste2.insert(yer, eleman)
            m += 1
        else:
            liste1.insert(yer, eleman)
            n += 1


def anlamsizleri_at(liste):
    for ind, i in enumerate(liste):
        if i != 0:
            return liste[ind:]


class Polinom:
    def __init__(self, katsayilar):
        self.liste = katsayilar
        self.boyut = len(katsayilar)

    def __str__(self):
        liste = []
        for index, i in enumerate(self.liste):
            if i != 0:
                liste.append(str(i) + 'x^' + str(self.boyut - index - 1))
        return (' + '.join(liste))

#toplama
    def __add__(self, p):
        p1, p2 = self.liste, p.liste
        liste = []
        eleman_sayilarini_esitle(p1, p2, 0, 0)
        L = len(p1)

        for i in range(0, L):
            liste.append(p1[i] + p2[i])
        return Polinom(liste)

#çıkartma
    def __sub__(self, p):
        p1, p2 = self.liste, p.liste
        eleman_sayilarini_esitle(p1, p2, 0, 0)
        liste = []
        L = len(p1)

        for i in range(0, L):
            liste.append(p1[i] - p2[i])

        return Polinom(liste)

#çarpma
    def __mul__(self, p):
        listem = [0] * (self.boyut + p.boyut)
        for index_i, i in enumerate(self.liste):
            for index_j, j in enumerate(p.liste):
                index = (self.boyut - index_i - 1) + (p.boyut - index_j - 1)
                listem[index] += i * j
        return Polinom(listem[::-1])

#bölme
    def __div__(self, p):
        listem1 = [0] * (self.boyut - p.boyut + 1)
        listem2 = [0] * (self.boyut - p.boyut + 1)
        p1 = self.liste
        p2 = p.liste
        for i in range(0, len(listem1)):
            if len(p1) >= len(p2):
                ekle = p1[0] * 1.0 / p2[0]
                index = len(p1) - len(p2)
                listem2[index] = ekle
                p1 = (Polinom(p1) - (Polinom(p2) * Polinom(listem2[::-1]))).liste
                listem2[index] = 0
                listem1[index] = ekle
                p1 = anlamsizleri_at(p1)
        return Polinom(listem1[::-1])
