# -*- coding: utf-8 -*-
def tc_no_dogrula(tc=10000000146):
    tc = str(tc)
    if type(tc) != str or len(tc) != 11 or tc < 0:
        print "Lütfen 11 basamaklı bir tamsayı giriniz"
    else:
        tc = str(tc)
        tc.split()
        tek_bsmk_top, cift_bsmk_top = 0, 0
        for index in range(1, len(tc) - 1):
            if index % 2 == 0:
                cift_bsmk_top += int(tc[index - 1])
            else:
                tek_bsmk_top += int(tc[index - 1])
        print cift_bsmk_top, tek_bsmk_top
        onuncu_bsmk = ((tek_bsmk_top * 7) - cift_bsmk_top) % 10
        on_birinci_bsmk = (tek_bsmk_top + cift_bsmk_top + onuncu_bsmk) % 10
        if onuncu_bsmk == int(tc[9]) and on_birinci_bsmk == int(tc[10]):
            print "TC Kimlik numarası geçerlidir"
        else:
            print "TC Kimlik numarası geçerli değildir"
