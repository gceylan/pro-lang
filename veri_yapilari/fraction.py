# -*- coding: utf-8 -*-
import math


def gcd(m, n):
    while m % n != 0:
        oldm = m
        oldn = n

        m = oldn
        n = oldm % oldn
    return n


class Fraction:

    def __init__(self, top, bottom):
        obeb = gcd(top, bottom)
        self.num = top / obeb
        self.den = bottom / obeb

#print ifadesi için metod
    def __str__(self):
        if self.den == 1:
            return str(self.num)
        return str(self.num) + '/' + str(self.den)

#ekranda göstermek için metod
    def show(self):
        if self.den == 1:
            print self.num
        else:
            print self.num, '/', self.den

#toplama işlemi için metod
    def __add__(self, f):
        if type(f) == type(1):
            return Fraction(self.den * f + self.num, self.den)

        pay = self.num * f.den + f.num * self.den
        payda = self.den * f.den
        return Fraction(pay, payda)

#çıkartma işlemi için metod veya her çıkartma bir toplamadır :)
    def __sub__(self, f):
        #pay = (self.num * f.den) - (f.num * self.den)
        #payda = self.den * f.den
        #return Fraction(pay, payda)
        return self + f * (-1)

#çarpma metodu
    def __mul__(self, f):
        if type(f) == type(1):
            return Fraction(self.num * f, self.den)

        pay = self.num * f.num
        payda = self.den * f.den
        return Fraction(pay, payda)

#bölme metodu
    def __div__(self, f):
        if type(f) == type(1):
            return Fraction(self.num, self.den * f)

        pay = self.num * f.den
        payda = self.den * f.num
        return Fraction(pay, payda)

#tamsayı üst alma
    def __pow__(self, us):
        if us > 0 or type(us) == type(0.5):
            return Fraction(self.num ** us, self.den ** us)
        if us <= 0:
            return Fraction((self.den * 1.0) ** -us, self.num ** -us)

    def __cmp__(self, f):
        f1_pay = self.num * f.den
        f2_pay = f.num * self.den

        if f1_pay > f2_pay:
            return 1
        elif f1_pay < f2_pay:
            return -1
        else:
            return 0

    def __float__(self):
        return float(self.num) / self.den
