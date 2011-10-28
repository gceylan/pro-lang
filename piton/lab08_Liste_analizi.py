# -*- coding: utf-8 -*-
su = ['H2O', 18, 0, 100.0, 'Bileşik', 'Kovalent', ['Hidrojen', 2],
      ['Oksijen', 1], 3, True]

def Liste_anaLizi(su):
    krkter, tam, ondalik, boolen, liste = 0, 0, 0, 0, 0
    for eleman in su:
        if type(eleman) == str:
            krkter += 1
        elif type(eleman) == int:
            tam += 1
        elif type(eleman) == float:
            ondalik += 1
        elif type(eleman) == bool:
            boolen += 1
        elif type(eleman) == list:
            liste += 1
    print "Karakter dizisi sayısı :", krkter
    print "Tamsayı sayısı         :", tam
    print "Ondalık sayı sayısı    :", ondalik
    print "Boolen sayısı          :", boolen
    print "Liste sayısı           :", liste
            

