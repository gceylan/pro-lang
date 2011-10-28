# -*- coding: utf-8 -*-
import csv


def not_hesapla(dosyam):
    dosya = open(dosyam)
    okuyucu = csv.reader(dosya)
    for i in okuyucu:
        ort = int(i[1]) * 0.4 + int(i[2]) * 0.6
        if ort > 60:
            print 'vizesi', i[1], 'finali', i[2], 'olan', i[0], ort, 'notu ile geçmiştir.'
        else:
            print 'vizesi', i[1], 'finali', i[2], 'olan', i[0], ort, 'notu ile kalmıştır.'
    dosya.close()
