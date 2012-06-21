# -*- coding: cp1254 -*-
import math
import time


# bu fonksiyon yardımıyla köke yaklaşımı gözleyebiliyoruz.
def analiz(liste):
    for ind, i in enumerate(liste):
        if i != 0:
            print "x[%s] = %s" % (ind, i)


# fonksiyon değerlerini "f" fonksiyonu yardımıyla hesaplattık...
def f(x, sbt):
    return math.e ** x - sbt

# sbt = e ^ x - c deki (c) ye sbt dedik.
# aralik listesi ile istediğimiz aralıktaki kökü arattık.
# x0, x1 değişkenleri sekant yöntemi için gerekli olan 2 başlangıç değeridir.
# epsilon hata payımız...
def sekant(sbt=5, aralik=[-1, 2], x0=1.1, x1=1.23, epsilon=10**-9, iterasyon=100):
    t1 = time.clock()
    ind = 0 	 # döngü için index tuttuk.
    x = [0] * 20 # f[x] işleminin sonuçlarını x listesinde tuttuk.
    x[0] = x0 	 # ilk 2 değer olan x0 ve x1 in değerlerini listeye yerleştirdik.
    x[1] = x1
    n = 1 		 # artık n değerimizi 1 den başlatabiliriz...

    durum = False
    
    # döngü yardımıyla Secant yöntemini uyguladık.
    while ind < iterasyon:
        # sekant formülü
        x[n+1] = x[n] - f(x[n], sbt) * (x[n] - x[n-1]) / (f(x[n], sbt) - f(x[n-1], sbt))

        # iki kökün epsilon ile olan durumları burada karşılaştırıldı.
        if abs(x[n + 1] - x[n]) > epsilon:
            n += 1
        else:
            for i in x[::-1]:
                if i != 0 and aralik[0] < i < aralik[1]: #bulunan kök aralıktaysa ekrana yazdır.
                    print "Kök: ", i
                    durum = True
                    break
            break
        ind += 1

    t2 = time.clock()
    print "time:", t2 - t1
    if durum:
        analiz(x)
    else:
        print "[%s, %s] aralığında epsilon = %s iken kök bulunamadı!" %(aralik[0], aralik[1], epsilon)

sekant()
