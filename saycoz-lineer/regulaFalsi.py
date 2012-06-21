# -*- coding: cp1254 -*-
import math
import time


def f(x, sbt):
    return math.e ** x - sbt


def regulaFalsi(sbt=5, a=1, b=2, iterasyon=100, epsilon=10 ** -9):
    t1 = time.clock()
    ind = 0

    #regula falsi yöntemini uygulamaya başlıyoruz...
    while ind < iterasyon:
        c = (a * f(b, sbt) - b * f(a, sbt)) / (f(b, sbt) - f(a, sbt))
        if abs(c) < epsilon:
            print "KÖK:", c
            break
        if f(a, sbt) * f(c, sbt) < 0:
            b = c
        else:
            a = c
        ind += 1

    t2 = time.clock()
    print "KÖK:", c
    print "time:", t2 - t1

regulaFalsi()
