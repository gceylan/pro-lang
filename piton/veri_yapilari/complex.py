# -*- coding: utf-8 -*-

class Complex:
    def __init__(self, reel, sanal):
        self.re = reel
        self.imj = sanal

    def __str__(self):
        return str(self.re) + " + " + str(self.imj) + "i"

    def __add__(self, c):
        if type(c) != Complex:
            return Complex(self.re + c, self.imj)
        return Complex(self.re + c.re, self.imj + c.imj)

    def __sub__(self, c):
        if type(c) != Complex:
            return Complex(self.re - c, self.imj)
        return Complex(self.re - c.re, self.imj - c.imj)

    def __mul__(self, c):
        if type(c) == type(1) or type(c) == type(1.0):
            return Complex(self.re * c, self.imj * c)
        new_re = self.re * c.re + self.imj * c.imj * -1
        new_imj = self.re * c.imj + c.re * self.imj
        return Complex(new_re, new_imj)

    def __div__(self, c, hassas = 4):
        if type(c) == type(1) or type(c) == type(1.0):
            return Complex(self.re / c * 1.0, self.imj / c * 1.0)
        new_c = Complex(c.re, c.imj * -1) * Complex(self.re, self.imj)
        payda = (c.re ** 2 + c.imj ** 2) ** 0.5
        return Complex(new_c.re / payda, new_c.imj / payda)

    def mutlak(self, c = 0):
        if type(c) == type(1) or type(c) == type(1.0):
            return (self.re ** 2 + self.imj ** 2) ** 0.5
        return ((self.re - c.re) ** 2 + (self.imj - c.imj) ** 2) ** 0.5
