#!/usr/bin/env python
#-*- coding: utf-8 -*-

from Tkinter import *
import sys
import time
import random


def temizle():
    ent_giris.delete(0, END)
    ent_sonuc.delete(0, END)
    zaman_ent.delete(0, END)


def zaman():
    return time.time()


def rasgele_sayi():
    ent_giris.delete(0, END)
    ent_sonuc.delete(0, END)
    zaman_ent.delete(0, END)
    x = random.randint(1, 9999999)
    ent_giris.insert(END, x)


def asal_mi():
    zaman_ent.delete(0, END)
    ent_sonuc.delete(0, END)
    sayi = ent_giris.get()
    t1 = zaman()
    s = []
    bolenler = []
    if int(sayi) > 1:
        if len(str(sayi)) > 8:
            x = "En fazla 8 basamaklı sayı giriniz."
        elif int(sayi) == 2:
            x = "Asal sayıdır."
        elif int(sayi) % int(2) == 0:  # asal çift sayı = 2
            x = "Asal sayı değildir. En küçük böleni : 2"
            t2 = zaman()
            sure = str(t2 - t1)
            zaman_ent.insert(END, sure[:7])
        else:
            while True:
                for i in range(3, int(sayi), 2):
                    if int(sayi) % int(i) == 0:   # asal değildir.
                        s.append(0)
                        bolenler.append(i)
                    else:               # asaldır.
                        s.append(1)
                if 0 not in s:
                    x = "Asal sayıdır."
                    t2 = zaman()
                    sure = str(t2 - t1)
                    zaman_ent.insert(END, sure[:7])
                else:
                    x = "Asal sayı değildir. En küçük böleni : %s" \
                        % bolenler[0]
                    t2 = zaman()
                    sure = str(t2 - t1)
                    zaman_ent.insert(END, sure[:7])
                break
    else:
        x = "Asal sayı değildir. En küçük asal sayı 2' dir"
    ent_sonuc.insert(END, x)

pencere = Tk()
pencere.geometry("500x250")
pencere.title("Asal sayılar")
pencere.resizable(width=FALSE, height=FALSE)

ent_giris = Entry()
ent_giris.place(relx=0.2, rely=0.1, relheight=0.10, relwidth=0.25)

ent_sonuc = Entry()
ent_sonuc.place(relx=0.2, rely=0.3, relheight=0.10, relwidth=0.70)

zaman_ent = Entry()
zaman_ent.place(relx=0.2, rely=0.5, relheight=0.10, relwidth=0.25)

L1 = Label(text="sayı:")
L1.place(relx=0.13, rely=0.1)

L2 = Label(text="sonuç:")
L2.place(relx=0.1, rely=0.3)

L3 = Label(text="işlem süresi(s):")
L3.place(relx=0.01, rely=0.5)

b1 = Button(text="kontrol et", command=asal_mi)
b1.place(relx=0.6, rely=0.7, relheight=0.10, relwidth=0.20)

b2 = Button(text="Temizle", command=temizle)
b2.place(relx=0.2, rely=0.7, relheight=0.10, relwidth=0.20)

b3 = Button(text="rasgele sayı", command=rasgele_sayi)
b3.place(relx=0.4, rely=0.7, relheight=0.10, relwidth=0.20)

b4 = Button(text="çıkış", command=sys.exit)
b4.place(relx=0.8, rely=0.7, relheight=0.10, relwidth=0.20)
