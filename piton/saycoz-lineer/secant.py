# -*- coding: cp1254 -*-
import math
import time


# bu fonksiyon yard�m�yla k�ke yakla��m� g�zleyebiliyoruz.
def analiz(liste):
    for ind, i in enumerate(liste):
        if i != 0:
            print "x[%s] = %s" % (ind, i)


# fonksiyon de�erlerini "f" fonksiyonu yard�m�yla hesaplatt�k...
def f(x, sbt):
    return math.e ** x - sbt

# sbt = e ^ x - c deki (c) ye sbt dedik.
# aralik listesi ile istedi�imiz aral�ktaki k�k� aratt�k.
# x0, x1 de�i�kenleri sekant y�ntemi i�in gerekli olan 2 ba�lang�� de�eridir.
# epsilon hata pay�m�z...
def sekant(sbt=5, aralik=[-1, 2], x0=1.1, x1=1.23, epsilon=10**-9, iterasyon=100):
    t1 = time.clock()
    ind = 0 	 # d�ng� i�in index tuttuk.
    x = [0] * 20 # f[x] i�leminin sonu�lar�n� x listesinde tuttuk.
    x[0] = x0 	 # ilk 2 de�er olan x0 ve x1 in de�erlerini listeye yerle�tirdik.
    x[1] = x1
    n = 1 		 # art�k n de�erimizi 1 den ba�latabiliriz...

    durum = False
    
    # d�ng� yard�m�yla Secant y�ntemini uygulad�k.
    while ind < iterasyon:
        # sekant form�l�
        x[n+1] = x[n] - f(x[n], sbt) * (x[n] - x[n-1]) / (f(x[n], sbt) - f(x[n-1], sbt))

        # iki k�k�n epsilon ile olan durumlar� burada kar��la�t�r�ld�.
        if abs(x[n + 1] - x[n]) > epsilon:
            n += 1
        else:
            for i in x[::-1]:
                if i != 0 and aralik[0] < i < aralik[1]: #bulunan k�k aral�ktaysa ekrana yazd�r.
                    print "K�k: ", i
                    durum = True
                    break
            break
        ind += 1

    t2 = time.clock()
    print "time:", t2 - t1
    if durum:
        analiz(x)
    else:
        print "[%s, %s] aral���nda epsilon = %s iken k�k bulunamad�!" %(aralik[0], aralik[1], epsilon)

sekant()
