# -*- coding: utf-8 -*-
import Image

#kuyruğun başı listenin başıdır(ilk elemanıdır).
class Queue:
    def __init__(self):
        self.items = []

    #kuyruğun sonuna item’ı ekle
    def enq(self, item):
        self.items.append(item)

    #kuyruğun bașındaki öğeyi çıkar, geri döndür, kuyruk güncellenir
    def deq(self, ind=0):
        return self.items.pop(ind)

    #kuyruğun içinde mi değil mi? İçindeyse False değilse True
    def notIn(self, item):
        return item not in self.items

    #kuyruk boș mu? Mantıksal değer
    def isEmpty(self):
        return self.items == []

    #kuyrukta kaç öğe var? Tamsayı değer
    def size(self):
        return len(self.items)

def region_growing(a, b):
    img = Image.open("kaynak.png")      #resimi image modülü ile açtık.
    s = Queue()     # bulduğum noktaları(pixelleri) depolamak için iki tane kuyruk oluşturdum.
    q = Queue()
    q.enq([a, b])   # girilen koordinatları liste şeklinde kuyruğa attık.

    if img.size[0] < a or img.size[1] < b:      # img.size bize resmin kaç pixel olduğunu söyler... (kaynak.png için 250 x 250)
        print "girdiğiniz pikseller resimin boyutundan büyük..."
    else:
        color = img.getpixel((a, b))     #rgba kodu.
        while (not q.isEmpty()):    # q kuyruğu boşalana kadar döngüyü çalıştır...
            pixel = q.deq()     # kuyruğun başındaki elemanı çektik. Kuyruğumuz iki elemanlı listelerden oluşmaktadır.
            x, y = pixel[0], pixel[1]   # kuyruktan çekilen listenin 0. indisi x koordinatını(pixel), 1. indisi y koordinatını(pixel) tutsun.

            if s.notIn([x, y]):     # [x, y] pixeli s kuyruğunda yok ise
                s.enq([x, y])       # [x, y] pixelini s kuyruğuna it.
                for i in range(-1, 2, 1):   # bu ve alttaki döngü ile seçilen pixelin çevresindeki pixellere bakıyorum...
                    for j in range(-1, 2, 1):
                        if (x + j) > 0:
                            if ([x + i, y + j] != [x, y] and img.getpixel((x + i, y + j)) == color):
                                q.enq([x + i, y + j])       # çevre pixeller([x + i, y + j]) ile renk örtüşüyorsa q kuyruguna it.
        while (not s.isEmpty()):    # s kuyruğu boşalana kadar aşağıdaki adımları yap...
            pop = s.deq()       # s den bir eleman çek ve pop değişkenine ata (pop pixeldir).
            img.putpixel((pop[0], pop[1]), (20, 100, 200, 0))   # artık pop değişkeni ile alınan her pixeli (20, 100, 200, 0) rgba renk koduyla dolguluyoruz...
        img.show()      # son olarak oluşan şekli ekranda gösteriyoruz...
        img.save("cıktı.png")       # resimin çıktısını aynı dizine kaydettim.

# örnek kullanım
#region_growing(120, 120)
