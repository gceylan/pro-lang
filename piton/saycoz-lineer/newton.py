# -*- coding: cp1254 -*-
import math
import time


# bu fonksiyon ile bulunan x de�erlerini topluca ekrana yazd�rd�k.
def analiz(liste):
    for ind, i in enumerate(liste):
        if i != 0:
            print "x[%s] = %s" % (ind, i)

# fonksiyon: e ^ x - c
#       sbt: fonksiyonun genel formunda verilen c sabitini temsil etmektedir.
#        x0: girilmesi gereken bir ba�lang�� de�eridir.
#   epsilon: hata pay�n� temsil etmektedir.
def newton(sbt=5, x0 = 1.5, aralik=[-5, 5], epsilon=10 ** -9, iterasyon=100):
    A = math.log(sbt)
    t1 = time.clock()
    ind = 0 		# d�ng� i�in bir index tuttuk.
    x = [0] * 20 	# x leri bu listede tutal�m.
    n = 0 			# x ler i�in index n = 0 ayarlad�k.
    x[n] = A + epsilon # x[0] de�erini hemen atad�k. Daha az i�lemde sonucu bulmak i�in x0 � k�ke epsilon yak�nl�kta bir de�er se�tik.
    durum = False

    while ind < iterasyon:

        # her defas�nda n de�erinin bir fazlas� olan x de�erlerini buluyoruz
        # �r: ilk olarak n = 0 oldu�undan
        # x[1] = x[0] - f[x] / f'[x] i�lemi yap�l�r ve sonucu 'x' listesine yaz�l�r.
        x[n + 1] = x[n] - ((math.e ** x[n] - sbt) / math.e ** x[n])

        # her ad�mda |x1 - x0| > epsilon kural�na uygun if blo�unu yazd�k.
        if abs(x[n + 1] - x[n]) > epsilon:
            n += 1
        # e�er |x1 - x0| < epsilon ise k�k� bulduk demektir.
        else:
            for i in x[::-1]:
                if i != 0 and aralik[0] < i < aralik[1]: # k�k aral�klarda ise ekrana yaz, yoksa k�k olmad���n� s�yle.
                    print "K�k: ", i
                    durum = True
                    break
            break
        ind += 1
    t2 = time.clock()
    # analiz fonksiyonunu �a��rarak bulunan x1, x2, x3... de�erlerini ekrana yazd�k.
    print "time:", t2 - t1
    if durum:
        analiz(x)
    else:
        print "[%s, %s] aral���nda epsilon = %s iken k�k bulunamad�!" % (aralik[0], aralik[1], epsilon)

# newton(20, 0.5, [1, 5], 10 ** -9, 20)
newton()
