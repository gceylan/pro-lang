#!/usr/bin/env python
#-*- coding: utf-8 -*-


def p_b(sayi):
    s = []
    for i in range(1, sayi):
        if sayi % i == 0:
            s.append(i)
    return s


def obeb_okek(s1, s2):
    if s1 % s2 == 0 or s2 % s1 == 0:
        if s1 > s2:
            print "obeb:", s2, "\nokek:", s1
        else:
            print "obeb:", s1, "\nokek:", s2
    else:
        n = p_b(s1)
        m = p_b(s2)
        s = []
        for i in n:
            for j in m:
                if i == j:
                    s.append(i)
        print "obeb :", s[len(s) - 1], "\nokek:", s1 * s2 / s[len(s) - 1]
