# -*- coding: utf-8 -*-

for n in range(2, 10):
    for x in range(2, n):
        if x % n == 0:
            print "1. print"
            break
    else:
        print "2. print"
