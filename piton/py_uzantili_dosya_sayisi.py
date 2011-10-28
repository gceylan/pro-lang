#!/usr/bin/env python
#-*- coding: utf-8 -*-

import os


def piton_betik_sayisi(yol='/home'):
    t = 0
    for i in os.walk(yol):
        for j in i[2]:
            L = len(j)
            n = j[L - 3:]
            if n == '.py':
                t += 1
    print '.py uzantılı dosya sayısı:', t
