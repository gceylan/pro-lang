# -*- coding: cp1254 -*-
import math
import time


def hesapla(x, sbt):
    return math.e ** x - sbt

# n = iterasyon say�s�
# sbt : e ** x - c deki c = sbt' dir.
# sbt = 1 olamaz.
# epsilon: hata pay�


def bisection(sbt=5, iterasyon=100, epsilon=10 ** -9):
    t1 = time.clock()
    A = math.log(sbt)
    f = {'a': None, 'b': None, 'c': None}
    a, b = A - epsilon, A + epsilon
    f['a'], f['b'] = hesapla(a, sbt), hesapla(b, sbt)

    ind = 0
    # bisection y�nteminde kullan�lan d�ng� ba�l�yor...
    # iterasyon say�s� kadar i�lem yap
    while ind < iterasyon:
        if f['a'] * f['b'] < 0:
            c = (a + b) / 2.0
            f['c'] = hesapla(c, sbt)
            if f['c'] == 0 or f['c'] == 0.0:
                print "K�K: ", c
                break
            else:
                if f['a'] * f['c'] < 0:
                    b = c
                else:
                    a = c
        ind += 1

    # print "f[x] = e ** x -", sbt, "denkleminin [%s, %s] aral���ndaki k�k�:" %(str(aralik[0]), str(aralik[1]))
    t2 = time.clock()
    print "time:", t2 - t1
    return a, b


print bisection()
