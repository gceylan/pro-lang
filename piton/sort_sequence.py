#!/usr/bin/env python
#-*- coding: utf-8 -*-
import doctest


def tur(seq):
    if type(seq) == type([]):
        return []
    if type(seq) == type(''):
        return ''
    return ()


def tur2(val, seq):
    if type(seq) == type(''):
        return str(val)
    if type(seq) == type([]):
        return [val]
    return (val,)


def sort_sequence(seq):
    """
      >>> sort_sequence([3, 4, 6, 7, 8, 2])
      [2, 3, 4, 6, 7, 8]
      >>> sort_sequence((3, 4, 6, 7, 8, 2))
      (2, 3, 4, 6, 7, 8)
      >>> sort_sequence("nothappy")
      'ahnoppty'
    """
    n = list(seq)
    n.sort()
    t = tur(seq)
    for i in n:
        t += tur2(i, seq)
    return t
doctest.testmod()
