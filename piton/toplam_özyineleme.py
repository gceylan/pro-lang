#!/usr/bin/env python
#-*- coding: utf-8 -*-


def ic_ice_listeleri_topla(seq):
    t = 0
    for i in seq:
        if type(i) == type([]):
            t += ic_ice_listeleri_topla(i)
        else:
            t += i
    return t
