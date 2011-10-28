#!/usr/bin/env python
#-*- coding: utf-8 -*-
import doctest


def tur(val, seq):
    if type(seq) == type(''):
        return str(val)
    if type(seq) == type([]):
        return [val]
    return (val,)


def insert_at_end(val, seq):
    """
      >>> insert_at_end(5, [1, 3, 4, 6])
      [1, 3, 4, 6, 5]
      >>> insert_at_end('x', 'abc')
      'abcx'
      >>> insert_at_end(5, (1, 3, 4, 6))
      (1, 3, 4, 6, 5)
    """
    return seq[:len(seq)] + tur(val, seq)
doctest.testmod()
