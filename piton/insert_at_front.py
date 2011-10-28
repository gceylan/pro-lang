#!/usr/bin/env python
#-*- coding: utf-8 -*-
import doctest


def tur(val, seq):
    if type(seq) == type(''):
        return str(val)
    if type(seq) == type([]):
        return [val]
    else:
        return (val,)


def insert_in_front(val, seq):
    """
      >>> insert_in_front(5, [1, 3, 4, 6])
      [5, 1, 3, 4, 6]
      >>> insert_in_front('x', 'abc')
      'xabc'
    """
    return tur(val, seq) + seq[:]
doctest.testmod()
