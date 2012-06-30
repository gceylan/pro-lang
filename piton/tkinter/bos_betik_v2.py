#!/usr/bin/env python
# -*- coding: utf-8 -*-

from Tkinter import *
import os
import sys

pencere = Tk()
pencere.geometry("200x75+75+50")
pencere.title("Gökhan CEYLAN")


def py_olustur():
    for i in range(0, 100):
        isim = 'betik' + str(i) + '.py'
        if isim  not in os.listdir(os.getcwd()):
            isim = isim
            break
    olustur = os.system('touch ' + isim)
    dosya = open(isim, 'w')
    dosya.write("#!/usr/bin/env python\n#-*- coding: utf-8 -*-")
    dosya.close()


dugme_1 = Button(text="py uzantılısı oluştur", command=py_olustur)
dugme_1.place(relx=0.0, rely=0.1, relwidth=1)

dugme_2 = Button(text="çıkış", command=sys.exit)
dugme_2.place(relx=0.0, rely=0.5, relwidth=1)

mainloop()
