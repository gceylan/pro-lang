#!/usr/bin/env python
#-*- coding: utf-8 -*-
import random

liste = []
while len(liste) != 10:
    n = random.randint(0, 100)
    liste.append(n)
print liste
