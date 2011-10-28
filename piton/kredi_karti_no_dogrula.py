#!/usr/bin/env python
#-*- coding: utf-8 -*-
#kullanılan kredi kartı numarası Australian BankCard' a aittir.
#sizde kendi kredi kartı numaranızla test edebilirsiniz.


def kredi_karti_numarasi_dogrula(no):
    no = str(no)
    if len(no) != 16:
        print "16 basamaklı pozitif tamsayı giriniz"
    else:
        tek_top, cift_top = 0, 0
        for i in range(0, 16):
            if i % 2 == 0:
                n = int(no[i]) * 2
                n = str(n)
                liste = list(n)
                for j in liste:
                    cift_top += int(j)
            else:
                tek_top += int(no[i])
        if (cift_top + tek_top) % 10 == 0:
            print "kredi kartı no doğrulandı"
        else:
            print "kredi kartı no doğrulanmadı"
kredi_karti_numarasi_dogrula(5610591081018250)
