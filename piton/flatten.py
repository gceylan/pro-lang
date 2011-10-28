#!/usr/bin/env python
#-*- coding: utf-8 -*-


def tek_liste(listem):
    t = []
    for i in listem:
        if type(i) == type([]):
            t.extend(tek_liste(i))
        else:
            t.append(i)
    return t
