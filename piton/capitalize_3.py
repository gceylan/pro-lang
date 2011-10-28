#!/usr/bin/env python
#-*- coding: utf-8 -*-
import string

def capitalize_3(cumle):
    liste = list(cumle)
    liste[0] = liste[0].upper()
    cumle_2 = string.join(liste, '')
    print cumle_2
