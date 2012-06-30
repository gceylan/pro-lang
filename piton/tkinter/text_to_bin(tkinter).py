#!/usr/bin/env python
# -*- coding: utf-8 -*-

from Tkinter import *
import sys
import string


def temizle():
    text_kutu.delete(1.0, END)
    bin_kutu.delete(1.0, END)


def yazdir(liste):
    dizgi = ""
    for i in liste:
        dizgi += i
    bin_kutu.insert(END, dizgi)


def text_to_bin():
    metin = text_kutu.get(1.0, END)
    bin_kutu.delete(1.0, END)
    ascii = ""
    ascii_liste = []
    L = len(ascii_liste)
    for i in metin:
        n = ord(i)
        while n:
            k = n % 2
            ascii += str(k)
            n /= 2
        L = len(ascii)
        if L != 8:
            ascii = ("0" * (8 - L)) + ascii[::-1]
        ascii_liste.append(ascii)
        ascii = ""
    yazdir(ascii_liste[:len(ascii_liste) - 1])    # boşluktan kurtulduk.


def bin_to_text():
    bin_sayi = bin_kutu.get(1.0, END)
    text_kutu.delete(1.0, END)
    bin_sayi = string.strip(bin_sayi)    # \n karakterinden kurtulduk.
    text = ''
    t = 0
    L = len(bin_sayi)
    for i in range(0, L, 8):
        sayi = bin_sayi[i: i + 8]
        sayi = sayi[::-1]
        for j in range(0, len(sayi)):
            t += (2 ** j) * int(sayi[j])
        text += chr(t)
        t = 0
    text_kutu.insert(END, text)

pencere = Tk()
pencere.title("From text to binary and back again")
pencere.geometry("620x400+150+100")

L1 = Label(text="Text")
L1.place(relx=0.02, rely=0.05)

text_kutu = Text(height=10, width=40, bg="white", fg="blue",
             font="Arial 10")
text_kutu.place(relx=0.02, rely=0.1)

L1 = Label(text="Binary")
L1.place(relx=0.52, rely=0.05)

bin_kutu = Text(height=10, width=40, bg="white", fg="blue",
             font="Arial 10")
bin_kutu.place(relx=0.52, rely=0.1)

B1 = Button(text="to bin", command=text_to_bin)
B1.place(relx=0.02, rely=0.55)

B2 = Button(text="to text", command=bin_to_text)
B2.place(relx=0.52, rely=0.55)

B3 = Button(text="restart", command=temizle)
B3.place(relx=0.52, rely=0.65)

B4 = Button(text="exit", command=sys.exit)
B4.place(relx=0.72, rely=0.65)

mainloop()
