# -*- coding: utf-8 -*-

import time

liste = []

# n özyineleme sayısıdır.
def bul(pay, payda, n=2):
    # başlangıç zamanı
    t1 = time.time()
    # fonksiyon özyineli olduğundan liste ve i değişkenlerini global tuttuk.
    # liste değişkeninde bulduğumuz i, j değerleri yer almaktadır.
    global liste, i
    if pay >= payda:
        print "Lütfen basit kesir giriniz."
    else:
        if n > 1:
            for i in range(2, 1001, 1):
                # 1/2, 2/4, 4/8 gibi özel durumları kontrol ediyoruz.
                if i * pay != payda:
                    # seçilen i değerine uygun j değerini buluyoruz. eğer j değeri tamsayı ise aradığımız değerdir.
                    # eğer bir tamsayı j değeri bulamıyorsak else bloğuna geçeceğiz. yanı girilen kesir en az iki kesrin toplamı değildir.
                    j = (float(i) * payda) / (i * pay - payda)
                    if int(j) == j and j > 0  and i != j:
                        liste.append("1/" + str(int(j)))
                        # bulunan i değerine göre 1/i yi 2 farklı kesrin toplamı olarak ayrıştırıyoruz. böylece n tane kesrin yoplamını elde ediyoruz.
                        #print pay, "/", payda, "=", "1 /", i,"+ 1 /", int(j)
                        return bul(1, i, n - 1)
                        #return bul(1, j, n - 1)

                    else:
                        # eğer kesir en az 2 kesrin toplamı şeklinde ifade edilmiyorsa 3. bir 1/k değeri araştıracağız.
                        for j in range(2, 1001, 1):
                            # eğer k değeri tamsayı ise aradığımız k değeridir. bu durumda i, j, k değerlerini listeye ekleyebiliriz.
                            k = float(i * j * payda) / ((i * j * pay) - (i + j) * payda)
                            if  k > 0 and i != j and j != k and i != k and int(k) == k:
                                liste.append("1/" + str(int(k)))
                                liste.append("1/" + str(int(j)))
                                # bulunan i değerine göre 1/i yi 2 farklı kesrin toplamı olarak ayrıştırıyoruz. böylece n tane kesrin yoplamını elde ediyoruz.
                                #print pay, "/", payda, "=", "1 /", i,"+ 1 /", int(j), "+ 1 /", int(k)
                                return bul(1, i, n - 1)
        else:
            liste.append("1/" + str(i))
            # listeyi birleştir be kullanıcıya sun
            print " + ".join(liste[::-1])
            # bitirme süresi
            print "time: " + str(time.time() - t1)

    liste = []

bul(1, 2)
bul(1, 2, 10)
bul(6, 7, 10)
bul(5, 23, 10)
bul(6, 89, 10)
bul(9, 10, 4)
bul(12, 997, 10)
