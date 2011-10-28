#!/usr/bin/env python
#-*- coding: utf-8 -*-
def capitalize_2(cumle="gökhan"):
    if 97 <= ord(cumle[0]) <= 122:
        n = chr(ord(cumle[0]) - 32)
        print n + cumle[1:]
