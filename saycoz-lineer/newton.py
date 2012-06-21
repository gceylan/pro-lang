# -*- coding: cp1254 -*-
import math
import time


# bu fonksiyon ile bulunan x değerlerini topluca ekrana yazdırdık.
def analiz(liste):
    for ind, i in enumerate(liste):
        if i != 0:
            print "x[%s] = %s" % (ind, i)

# fonksiyon: e ^ x - c
#       sbt: fonksiyonun genel formunda verilen c sabitini temsil etmektedir.
#        x0: girilmesi gereken bir başlangıç değeridir.
#   epsilon: hata payını temsil etmektedir.
def newton(sbt=5, x0 = 1.5, aralik=[-5, 5], epsilon=10 ** -9, iterasyon=100):
    A = math.log(sbt)
    t1 = time.clock()
    ind = 0 		# döngü için bir index tuttuk.
    x = [0] * 20 	# x leri bu listede tutalım.
    n = 0 			# x ler için index n = 0 ayarladık.
    x[n] = A + epsilon # x[0] değerini hemen atadık. Daha az işlemde sonucu bulmak için x0 ı köke epsilon yakınlıkta bir değer seçtik.
    durum = False

    while ind < iterasyon:

        # her defasında n değerinin bir fazlası olan x değerlerini buluyoruz
        # ör: ilk olarak n = 0 olduğundan
        # x[1] = x[0] - f[x] / f'[x] işlemi yapılır ve sonucu 'x' listesine yazılır.
        x[n + 1] = x[n] - ((math.e ** x[n] - sbt) / math.e ** x[n])

        # her adımda |x1 - x0| > epsilon kuralına uygun if bloğunu yazdık.
        if abs(x[n + 1] - x[n]) > epsilon:
            n += 1
        # eğer |x1 - x0| < epsilon ise kökü bulduk demektir.
        else:
            for i in x[::-1]:
                if i != 0 and aralik[0] < i < aralik[1]: # kök aralıklarda ise ekrana yaz, yoksa kök olmadığını söyle.
                    print "Kök: ", i
                    durum = True
                    break
            break
        ind += 1
    t2 = time.clock()
    # analiz fonksiyonunu çağırarak bulunan x1, x2, x3... değerlerini ekrana yazdık.
    print "time:", t2 - t1
    if durum:
        analiz(x)
    else:
        print "[%s, %s] aralığında epsilon = %s iken kök bulunamadı!" % (aralik[0], aralik[1], epsilon)

# newton(20, 0.5, [1, 5], 10 ** -9, 20)
newton()
