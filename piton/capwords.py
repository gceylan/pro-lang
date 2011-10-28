#!/usr/bin/env python
# -*- coding: utf-8 -*-
def capwords(cumle="merhaba gkhan"):
    kelimeler = cumle.split()
    for kelime in kelimeler:
        if 97 <= ord(kelime[0]) <= 122:
            n = chr(ord(kelime[0]) - 32)
            print (n + kelime[1:]),
        else:
            print cumle
